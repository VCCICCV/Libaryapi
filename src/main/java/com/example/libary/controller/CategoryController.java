package com.example.libary.controller;

import com.example.libary.common.Result;
import com.example.libary.controller.request.AdminPageRequest;
import com.example.libary.controller.request.CategoryPageRequest;
import com.example.libary.entity.Category;
import com.example.libary.service.ICategoryService;
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
@RequestMapping ("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @DeleteMapping ("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }
    @PutMapping ("/update")
    public Result update(@RequestBody Category obj) {
        categoryService.update(obj);
        return Result.success();
    }
    @GetMapping ("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category obj = categoryService.getById(id);
        return Result.success(obj);
    }
    @PostMapping ("/save")
    public Result save(@RequestBody Category obj) {
        categoryService.save(obj);
        return Result.success();
    }
    @GetMapping ("/list")
    public Result list() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }
    @GetMapping ("/page")
    public Result page(AdminPageRequest pageRequest) {
        return Result.success(categoryService.page(pageRequest));
    }
}