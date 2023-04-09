package com.example.libary.mapper;

import com.example.libary.controller.request.UserPageRequest;
import com.example.libary.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:38
 */
@Mapper
public interface UserMapper {
    // @Select ("select * from user")
    List<User> list();

    List<User> listByCondition(UserPageRequest userPageRequest);
}
