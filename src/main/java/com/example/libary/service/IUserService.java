package com.example.libary.service;

import com.example.libary.controller.request.UserPageRequest;
import com.example.libary.entity.User;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:41
 */
public interface IUserService {
    List<User> list();
    Object page(UserPageRequest userPageRequest);

    void save(User user);

    User getById(Integer id);

    void update(User user);
}
