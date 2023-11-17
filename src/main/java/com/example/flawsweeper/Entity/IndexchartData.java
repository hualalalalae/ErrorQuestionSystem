package com.example.flawsweeper.Entity;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//首页需要返回的数据
@Data
public class IndexchartData {
    private List<Long> barddata; //错题本，收藏夹，回收站的各自错题数量Map<String,Long>
    private List<Integer> piedata; //4科每科的错题数量List<Classify>
    private ArrayList<List<Integer>> linedata;//近7天每天的4科各自的添加错题数List<Map<String,Classify>>
}
