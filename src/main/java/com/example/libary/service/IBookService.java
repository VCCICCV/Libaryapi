package com.example.libary.service;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Book;
import com.example.libary.entity.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/6 20:10
 */
public interface IBookService {
    List<Book> list();

    PageInfo<Book> page(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void update(Book obj);

    void deleteById(Integer id);
}
