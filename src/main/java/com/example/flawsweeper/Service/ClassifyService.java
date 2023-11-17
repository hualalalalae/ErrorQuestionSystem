package com.example.flawsweeper.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.flawsweeper.Entity.Classify;

import java.util.List;

public interface ClassifyService extends IService<Classify> {

    List<Classify> getclassifycount(int uid);
    //仅七天添加错题数据
    List<Classify> latelycount(int day,int uid);
}
