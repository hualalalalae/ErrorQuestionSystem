package com.example.flawsweeper.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.flawsweeper.Entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//用于实现首页数据
@Mapper
public interface ClassifyMapper extends BaseMapper<Classify> {

    //各科错题数
    List<Classify> getclassifycount(@Param("uid") int uid);

    //仅七天添加的各科错题数

    List<Classify> latelycount(@Param("day") int day,@Param("uid") int uid);

}
