package com.example.libary.mapper;

import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/14 21:33
 */
@Mapper
public interface BorrowMapper {
    List<Borrow> list();

    List<Borrow> listByCondition(BaseRequest baseRequest);

    void save(Borrow obj);

    Borrow getById(Integer id);

    void updateById(Borrow user);

    void deleteById(Integer id);
}
