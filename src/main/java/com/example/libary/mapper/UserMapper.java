package com.example.libary.mapper;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.User;
import org.apache.ibatis.annotations.Mapper;

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

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(Integer id);

    void updateById(User user);

    void deleteById(Integer id);
}
