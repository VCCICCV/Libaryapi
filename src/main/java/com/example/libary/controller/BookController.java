package com.example.libary.controller;

import com.example.libary.common.Result;
import com.example.libary.controller.request.BookPageRequest;
import com.example.libary.entity.Book;
import com.example.libary.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:50
 */
@CrossOrigin// 解决跨域
@RestController
@RequestMapping ("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @DeleteMapping ("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        bookService.deleteById(id);
        return Result.success();
    }

    @PutMapping ("/update")
    public Result update(@RequestBody Book obj) {
        bookService.update(obj);
        return Result.success();
    }

    @GetMapping ("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book obj = bookService.getById(id);
        return Result.success(obj);
    }

    @PostMapping ("/save")
    public Result save(@RequestBody Book obj) {
        bookService.save(obj);
        return Result.success();
    }

    @GetMapping ("/list")
    public Result list() {
        List<Book> list = bookService.list();
        return Result.success(list);
    }

    @GetMapping ("/page")
    public Result page(BookPageRequest pageRequest) {
        return Result.success(bookService.page(pageRequest));
    }
}