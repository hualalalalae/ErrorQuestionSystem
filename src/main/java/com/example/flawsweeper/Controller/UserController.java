package com.example.flawsweeper.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.flawsweeper.Common.Result;
import com.example.flawsweeper.Common.jwtUtils;
import com.example.flawsweeper.Entity.User;
import com.example.flawsweeper.Mapper.UserMapper;
import com.example.flawsweeper.Service.UserService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody  User user){
        //1.账号密码至少其一为空
        if(user.getUsername()==null||user.getPassword()==null){
            return Result.error("-1","账号密码不能为空！");
        }
        //2.不为空
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        wrapper.eq("password",user.getPassword());
        User users = userService.getOne(wrapper);
        System.out.println("输入的用户："+user.getUsername());

        if(users!=null){
            //生成令牌
            String token = jwtUtils.generateToken(String.valueOf(users.getUid()));
            System.out.println("生成的token:"+token);
            users.setToken(token);
            return Result.success(users);
        }
        //3.账号密码错误,返回提示
        return Result.error("-1","账号密码错误！");}

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        if (user.getUsername()!=null&&user.getPassword()!=null&&user.getNickname()!=null){
            //账户不应重复
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",user.getUsername());
            User user1 = userService.getOne(wrapper);
            if (user1==null){
                boolean flag = userService.save(user);
                if(flag) return Result.success();//返回成功信息
                else return Result.error("-1","注册失败");
            }
            //否则返回账号重复提示
            else return Result.error("-1","该账号已注册！");
        }
        else return Result.error("-1","账号、密码、昵称不应为空");
    }
}
