package com.example.flawsweeper.Entity;

import lombok.Data;

import java.util.List;

//分页数据
@Data
public class PageBean<T> {
    //总记录数
    private Long totalCount;
    //当前页数据
    private List<T> row;


}
