package com.example.libary.service.impl;

import com.example.libary.entity.User;
import com.example.libary.mapper.UserMapper;
import com.example.libary.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:42
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> listUsers() {

        return userMapper.listUsers();
    }
}
