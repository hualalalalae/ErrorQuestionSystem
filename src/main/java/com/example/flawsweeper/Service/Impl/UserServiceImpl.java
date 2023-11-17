package com.example.flawsweeper.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.flawsweeper.Entity.User;
import com.example.flawsweeper.Mapper.UserMapper;
import com.example.flawsweeper.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
}
