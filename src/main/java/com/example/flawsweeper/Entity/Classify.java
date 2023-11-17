package com.example.flawsweeper.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//分类
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("flawsweeper.classify")
public class Classify {
    @TableId
    private int classifyid;
    private String classifyname;

    @TableField(exist = false)
    private int datacount;//作为首页所需错题数据量

}
