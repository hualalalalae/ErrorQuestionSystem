package com.example.flawsweeper.Entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

import java.util.Date;
import java.util.List;

//错题
@Data
@TableName(value = "flawsweeper.errorquestion" ,resultMap = "questionClass")
public class ErrorQuestion {
    @TableId(type = IdType.AUTO)
    private Integer questionid;

    private Integer uid;//用户id

    private String title1;//题干
    private List<String> title2;//题目选项，选择题则需要输入选项
    private Integer titletype;//题目类型：选择（1）、非选择（0）

    private String answer;
    private String analysis;//分析

    private List<String> notes;//标签

    private Integer classifyid;//分类

    private Date questiontime;//错题创建日期

    private Integer inrecycle;//是否在回收站内：是（1）、否（0）

    private Integer incollect;//是否在收藏夹内：是（1）、否（0）

    private String imagesrc;//存入数据库的图片路径

    private Integer proficiency;//熟练度

}
