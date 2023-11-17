package com.example.flawsweeper.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.flawsweeper.Common.Result;
import com.example.flawsweeper.Common.jwtUtils;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.PageBean;
import com.example.flawsweeper.Entity.User;
import com.example.flawsweeper.Service.ClassifyService;
import com.example.flawsweeper.Service.QuestionService;
import com.example.flawsweeper.Service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//此控制层只写题目搜索接口
@CrossOrigin //跨域
@Controller
@ResponseBody
@RequestMapping("/search")
public class SearchController {
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

    /* 搜索--题干
   keyword为关键词
   */
    @GetMapping("/selectbytitle/{classifyid}/{keyword}/{currentPage}/{pageSize}")
    public Result<PageBean> selectbytitle(@PathVariable Integer classifyid, @PathVariable String keyword, @PathVariable Integer currentPage , @PathVariable Integer pageSize, @RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("classifyid",classifyid).eq("inrecycle",0);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("title1",keyword);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }
    //搜索--标签,note为搜索关键词
    @GetMapping("/selectbynote/{classifyid}/{note}/{currentPage}/{pageSize}")
    public Result<PageBean> selectbynote(@PathVariable Integer classifyid,@PathVariable String note,@PathVariable Integer currentPage ,@PathVariable Integer pageSize,@RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("classifyid",classifyid).eq("inrecycle",0);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("notes",note);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }

    //搜索--回收站(题干)
    @GetMapping("/selectrecyclebytitle/{keyword}/{currentPage}/{pageSize}")
    public Result<PageBean> selectrecyclebytitle( @PathVariable String keyword, @PathVariable Integer currentPage , @PathVariable Integer pageSize,@RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("inrecycle",1);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("title1",keyword);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }
    //搜索--回收站(标签)
    @GetMapping("/selectrecyclebynote/{note}/{currentPage}/{pageSize}")
    public Result<PageBean> selectrecyclebynote(@PathVariable String note, @PathVariable Integer currentPage , @PathVariable Integer pageSize, @RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("inrecycle",1);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("notes",note);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }
    //搜索--收藏夹(题干)
    @GetMapping("/selectcollectbytitle/{keyword}/{currentPage}/{pageSize}")
    public Result<PageBean> selectcollectbytitle( @PathVariable String keyword, @PathVariable Integer currentPage , @PathVariable Integer pageSize, @RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("incollect",1);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("title1",keyword);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }
    //搜索--收藏夹(标签)
    @GetMapping("/selectcollectbynote/{note}/{currentPage}/{pageSize}")
    public Result<PageBean> selectcollectbynote(@PathVariable String note, @PathVariable Integer currentPage , @PathVariable Integer pageSize, @RequestHeader String Authorization){
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",getuserid(Authorization)).eq("incollect",1);
        IPage page = new Page(currentPage,pageSize);
        wrapper.like("notes",note);
        questionService.page(page, wrapper);
        pageBean.setRow(page.getRecords());
        pageBean.setTotalCount(page.getTotal());
        return Result.success(pageBean);
    }

}
