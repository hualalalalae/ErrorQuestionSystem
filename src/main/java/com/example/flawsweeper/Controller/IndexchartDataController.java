package com.example.flawsweeper.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.flawsweeper.Common.Result;
import com.example.flawsweeper.Common.jwtUtils;
import com.example.flawsweeper.Entity.Classify;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.IndexchartData;
import com.example.flawsweeper.Entity.User;
import com.example.flawsweeper.Service.ClassifyService;
import com.example.flawsweeper.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class IndexchartDataController {
    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private QuestionService questionService;

    //获取当前登录用户id
    public Integer getuserid(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        String uid = jwtUtils.getClaimsByToken(token).getSubject();
        return Integer.parseInt(uid);
    }

    //返回首页数据
    @GetMapping("/index")
    public Result<IndexchartData> getindexcount(@RequestHeader String Authorization){
        Integer uid = getuserid(Authorization);
        IndexchartData indexchartData = new IndexchartData();
        //错题本，收藏夹，回收站的各自错题数量
        indexchartData.setPiedata(getclassifycount(uid));
        //4科每科的错题数量及科目
        indexchartData.setBarddata(gettotalcount(uid));
        // 近7天每天的4科各自的添加错题数
        indexchartData.setLinedata(getlatelycount(uid));
        return Result.success(indexchartData);
    }

    //返回4科每科的错题数量及科目
    public List<Integer> getclassifycount(int uid){
        ArrayList<Integer> list2 = new ArrayList<>();
        List<Classify> list = classifyService.getclassifycount(uid);
        for (int i = 0; i <list.size() ; i++) {
            list2.add(list.get(i).getDatacount());
        }
        System.out.println(list);
        System.out.println(list2);
        return list2;
    }

    //按错题本，收藏夹，回收站顺序返回数据
    public List<Long> gettotalcount(int uid){
        ArrayList<Long> list = new ArrayList<>();
        QueryWrapper<ErrorQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid).eq("inrecycle",0);
        long total = questionService.count(wrapper);

        QueryWrapper<ErrorQuestion> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("incollect","1").eq("uid",uid);
        long collect = questionService.count(queryWrapper1);

        QueryWrapper<ErrorQuestion> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("inrecycle","1").eq("uid",uid);
        long recycle = questionService.count(queryWrapper2);
        list.add(total);
        list.add(collect);
        list.add(recycle);
        return list;
    }
    // 近7天每天的4科各自的添加错题数
    public ArrayList<List<Integer>> getlatelycount(int uid){
        ArrayList<List<Integer>> list2_1 = new ArrayList<>();
        ArrayList<List<Integer>> list2_2 = new ArrayList<>();
        List<Map<String, Classify>> list = new ArrayList<Map<String, Classify>>();
        Map<String, Classify> map = new HashMap<>();
        for (int i = 0; i <=6 ; i++) {//0为当天,6为往前第七天
            ArrayList<Integer> list1_1 = new ArrayList<>();
            list1_1.add(classifyService.latelycount(i, uid).get(0).getDatacount());//数学
            list1_1.add(classifyService.latelycount(i, uid).get(1).getDatacount());//英语
            list1_1.add(classifyService.latelycount(i, uid).get(2).getDatacount());//政治
            list1_1.add(classifyService.latelycount(i, uid).get(3).getDatacount());//专业课
            list2_1.add(list1_1);
        }
        for (int i = 0; i < 4 ; i++) {
            ArrayList<Integer> list1_2 = new ArrayList<>();
            list1_2.add(list2_1.get(0).get(i));
            list1_2.add(list2_1.get(1).get(i));
            list1_2.add(list2_1.get(2).get(i));
            list1_2.add(list2_1.get(3).get(i));
            list1_2.add(list2_1.get(4).get(i));
            list1_2.add(list2_1.get(5).get(i));
            list1_2.add(list2_1.get(6).get(i));
            list2_2.add(list1_2);
        }
        return list2_2;
    }

}
