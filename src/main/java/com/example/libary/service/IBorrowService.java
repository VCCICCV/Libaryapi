package com.example.libary.service;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Borrow;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/6 20:10
 */
public interface IBorrowService {
    List<Borrow> list();

    PageInfo<Borrow> page(BaseRequest baseRequest);

    void save(Borrow obj);

    Borrow getById(Integer id);

    void update(Borrow obj);

    void deleteById(Integer id);

    Object getCountByTimeRange(String timeRange);
}
