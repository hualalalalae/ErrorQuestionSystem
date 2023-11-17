package com.example.flawsweeper.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.flawsweeper.Entity.Classify;
import com.example.flawsweeper.Mapper.ClassifyMapper;
import com.example.flawsweeper.Service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    //仅七天添加错题数据
    @Override
    public List<Classify> latelycount(int day,int uid) {
        return classifyMapper.latelycount(day,uid);
    }


    @Override
    public List<Classify> getclassifycount(int uid) {
        return classifyMapper.getclassifycount(uid);
    }
}
