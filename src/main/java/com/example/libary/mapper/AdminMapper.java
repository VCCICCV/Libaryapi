package com.example.libary.mapper;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.controller.request.LoginRequest;
import com.example.libary.controller.request.PasswordRequest;
import com.example.libary.entity.Admin;
import com.example.libary.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:38
 */
@Mapper
public interface AdminMapper {
    List<Admin> list();
    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void updateById(Admin user);

    void deleteById(Integer id);

    // Admin getByUsernameAndPassword(@Param("username") String username, @Param ("password") String password);
    int updatePassword(PasswordRequest request);
    Admin getByUsername(@Param("username") String username);

    void resetPassById(Admin user);
}
