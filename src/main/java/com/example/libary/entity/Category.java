package com.example.libary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/6 9:23
 */
@Data
public class Category {
    private Integer id;
    private String name;
    private String remark;
    private Integer pid;
    @JsonFormat (pattern = "yyy-MM-dd",timezone = "GMT+8")
    private LocalDate createtime;
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GMT+8")
    private LocalDate updatetime;
    private List<Category> children;
}
