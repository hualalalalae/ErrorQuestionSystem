package com.example.flawsweeper.Entity.dto;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedoQuestionDTO implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 分类
     */
    private String classifyname;

    /**
     * 题目类型：选择（1）、非选择（0）、随机（2）
     */
    private Integer titletype;


}
