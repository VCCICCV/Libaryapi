package com.example.libary.service;

import com.example.libary.controller.dto.LoginDTO;
import com.example.libary.controller.request.BaseRequest;
import com.example.libary.controller.request.LoginRequest;
import com.example.libary.controller.request.PasswordRequest;
import com.example.libary.entity.Admin;
import com.example.libary.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:41
 */
public interface IAdminService {
    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void update(Admin obj);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest request);
    void changePass(PasswordRequest request);
}
