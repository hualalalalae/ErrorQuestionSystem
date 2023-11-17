package com.example.flawsweeper.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("flawsweeper.b_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    @TableField(exist = false)
    private String token;
}