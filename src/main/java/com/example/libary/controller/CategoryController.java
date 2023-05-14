package com.example.libary.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.libary.common.Result;
import com.example.libary.controller.request.AdminPageRequest;
import com.example.libary.controller.request.CategoryPageRequest;
import com.example.libary.entity.Category;
import com.example.libary.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping ("/tree")
    public Result tree() {
        List<Category> list = categoryService.list();
        // 对list操作
        // List<Category> treeList = list.stream().filter(v -> v.getPid() == null).collect(Collectors.toList());// 第一层
        // 递归实现列表查询
        return Result.success(createTree(null, list));
    }

    // 完全递归的方法来实现递归树
    private List<Category> createTree(Integer pid, List<Category> categories) {
        List<Category> treeList = new ArrayList<>();
        for (Category category : categories) {
            if (pid == null) {
                if (category.getPid() == null) {  // 那这就是第一级节点
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            } else {
                if (pid.equals(category.getPid())) {
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            }
            // 下级为空
            if (CollUtil.isEmpty(category.getChildren())) {
                category.setChildren(null);
            }
        }
        return treeList;
    }

    @GetMapping ("/page")
    public Result page(CategoryPageRequest pageRequest) {
        return Result.success(categoryService.page(pageRequest));
    }
}