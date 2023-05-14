package com.example.libary.mapper;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:38
 */
@Mapper
public interface BookMapper {
    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void updateById(Book user);

    void deleteById(Integer id);
}
