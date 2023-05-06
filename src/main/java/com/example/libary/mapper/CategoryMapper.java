package com.example.libary.mapper;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.controller.request.PasswordRequest;
import com.example.libary.entity.Category;
import com.example.libary.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:38
 */
@Mapper
public interface CategoryMapper {
    List<Category> list();
    List<Category> listByCondition(BaseRequest baseRequest);

    void save(Category obj);

    Category getById(Integer id);

    void updateById(Category user);

    void deleteById(Integer id);
}
