package com.example.libary.service.impl;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Book;
import com.example.libary.mapper.BookMapper;
import com.example.libary.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/6 20:10
 */
@Service
@Slf4j
public class BookService implements IBookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public PageInfo<Book> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Book> books = bookMapper.listByCondition(baseRequest);
        return new PageInfo<>(books);
    }

    @Override
    public void save(Book obj) {
        bookMapper.save(obj);
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public void update(Book obj) {
        // 更新时间
        obj.setUpdatetime(LocalDate.now());
        bookMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        bookMapper.deleteById(id);
    }
}
