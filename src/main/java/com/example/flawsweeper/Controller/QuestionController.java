package com.example.flawsweeper.Controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.flawsweeper.Common.Result;
import com.example.flawsweeper.Common.StringUtil;
import com.example.flawsweeper.Common.jwtUtils;
import com.example.flawsweeper.Entity.Classify;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.PageBean;
import com.example.flawsweeper.Entity.User;

import com.example.flawsweeper.Entity.dto.RedoQuestionDTO;
import com.example.flawsweeper.Entity.vo.QuestionVo;
import com.example.flawsweeper.Service.ClassifyService;
import com.example.flawsweeper.Service.QuestionService;
import com.example.flawsweeper.Service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@CrossOrigin //跨域
@Controller
@ResponseBody
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private ClassifyService classifyService;

    PageBean pageBean = new PageBean();

    //获取当前登录用户id
    public Integer getuserid(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        String uid = jwtUtils.getClaimsByToken(token).getSubject();
        return Integer.parseInt(uid);
    }

    //1. 添加错题
    @PostMapping("/addQuestion")
    public Result<Integer> addQuestion(@RequestBody ErrorQuestion question,@RequestHeader String Authorization) throws IOException {
        //设置用户id
        question.setUid(getuserid(Authorization));
//        question.setUid(1);
        //初始化收藏状态、时间、不在回收站
        question.setQuestiontime(new Date());
        question.setIncollect(0);
        question.setInrecycle(0);


        if(question.getNotes()==null) question.setNotes(new ArrayList<>());
        if(question.getTitle2()==null) question.setTitle2(new ArrayList<>());
        //错题插入错题本
        questionService.addQuestion(question);
        int questionid = question.getQuestionid();
        System.out.println(questionid);
        return Result.success(questionid);
    }

    //2. 错题详情页
    @GetMapping("/show/{questionid}")
    public Result<Map<String,Object>> showQuestion(@PathVariable int questionid) {
        Map<String, Object> errorQuestion = questionService.getQuestionMessage(questionid);
        System.out.println(errorQuestion);
        return  Result.success(errorQuestion);
    }
    //3. 修改错题
    @PostMapping("/updateQuestion")
    public Result updateQuestion(@RequestBody ErrorQuestion errorQuestion) throws IOException {//图片数据应是String型url地址
        //只修改题干、答案、分析、标签、图片url(string类型)、熟练度等级
        ErrorQuestion questionServiceById = questionService.getById(errorQuestion.getQuestionid());
        System.out.println(questionServiceById);
        errorQuestion.setQuestiontime(questionServiceById.getQuestiontime());
        errorQuestion.setIncollect(questionServiceById.getIncollect());
        errorQuestion.setInrecycle(questionServiceById.getInrecycle());
        if(errorQuestion.getTitletype()==0) {//1是选择，0非选择
            errorQuestion.setTitle2(new ArrayList<>());//非选择题将选项置为空
        }
        ErrorQuestion oldquestion = questionService.getQuestionClass(errorQuestion.getQuestionid());
        if(oldquestion.equals(errorQuestion)){ return Result.success(); }//判断有无修改
        else {
            errorQuestion.setQuestiontime(new Date());//有修改则更新错题时间
            if (errorQuestion.getNotes() == null) errorQuestion.setNotes(new ArrayList<>());
            if (errorQuestion.getTitle2() == null) errorQuestion.setTitle2(new ArrayList<>());

            boolean flag = questionService.updateQuestion(errorQuestion);
            if (flag) return Result.success();
            return Result.error("-1", "修改失败");
        }

    }
    //4. 将错题放入回收站，并取消收藏
    @GetMapping("/deleteQuestion/{questionid}")
    public Result deleteQuestion(@PathVariable int questionid){
        ErrorQuestion question = questionService.getById(questionid);
        System.out.println(question);
        questionService.updateinrecycle(questionid);
        return Result.success();
    }

    //5.移除出回收站
    @GetMapping("/recoverQuestion/{questionid}")
    public Result recoverQuestion(@PathVariable int questionid){
        questionService.recoverQuestion(questionid);
        return Result.success();
    }

    //6.  回收站中彻底删除错题
    @GetMapping("/recycle/{questionid}")
    public Result permanentDeleteQuestion(@PathVariable int questionid){
        // 从数据库中删除错题
        boolean flag = questionService.removeById(questionid);
        if(flag)
            return Result.success("彻底删除成功");
        else
            return Result.error("-1","删除失败");
    }

    //7.添加入收藏夹，此前一定不在收藏夹中且不在回收站中
    @GetMapping("/IntoCollect/{questionid}")
    public Result intocollect(@PathVariable int questionid){
        boolean flag = questionService.intocollect(questionid);
        if(flag) return Result.success();
        return Result.error("-1","添加失败");
    }

    //8.移出收藏夹
    @GetMapping("/deleteCollect/{questionid}")
    public Result deleteCollect(@PathVariable int questionid){
        boolean flag = questionService.deleteCollect(questionid);
        if(flag) return Result.success();
        return Result.error("-1","移除失败");
    }

    //9.分类：展示学科id、学科名、该学科错题总数
    @GetMapping("/selectbyclassify")
    public Result<List<Classify>> selectbyclassify(@RequestHeader String Authorization){
        List<Classify> getclassifycount = classifyService.getclassifycount(getuserid(Authorization));
        return Result.success(getclassifycount);
    }

    //10.分页--回收站
    @GetMapping("/pagebyrecycle/{currentPage}/{pageSize}")
    public Result<PageBean> pagebyrecycle(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("inrecycle",1);
        IPage page = new Page(currentPage,pageSize);
        questionService.page(page,wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }
    //11.分页--收藏夹
    @GetMapping("/pagebycollect/{currentPage}/{pageSize}")
    public Result<PageBean> pagebycollect(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("incollect",1);
        IPage page = new Page(currentPage,pageSize);
        questionService.page(page,wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }

    //13.分页--学科
    @GetMapping("/pagebyclassify/{classifyid}/{currentPage}/{pageSize}")
    public Result<PageBean> pagebyclassify(@PathVariable Integer classifyid,@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("inrecycle",0).eq("classifyid",classifyid).orderByDesc("questiontime");
        IPage page = new Page(currentPage,pageSize);
        questionService.page(page,wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }

    /**
     * 按照条件抽取5道错题
     */
    @PostMapping ("/getRedoQuestion")
    public Result<List<Map<String,Object>>> getRedoQuestion(@RequestBody RedoQuestionDTO redoQuestionDTO, @RequestHeader String Authorization){
        if(redoQuestionDTO.getClassifyname().equals("随机")){
            redoQuestionDTO.setClassifyname(null);
        }
        //设置用户id
        redoQuestionDTO.setUid(getuserid(Authorization));
//        redoQuestionDTO.setUid(1);
        System.out.println("传入的参数："+redoQuestionDTO);
        List<Map<String,Object>> list = questionService.getRedoQuestion(redoQuestionDTO);
        System.out.println("title2:----"+list);
        return Result.success(list);
    }


    /**
     * 获取所有错题分类
     * @return
     */
    @GetMapping("/choiceQuestion")
    public Result<List<Classify>> getClassify(){
        List<Classify> classifyList = classifyService.list();
        return Result.success(classifyList);
    }
}
