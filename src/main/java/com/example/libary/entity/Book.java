package com.example.libary.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/8 23:06
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 出版日期
     */
    private String publishDate;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 分类
     */
    private String category;

    /**
     * 标准码
     */
    private String bookNo;

    /**
     * 创建时间
     */
    private LocalDate createtime;

    /**
     * 更新时间
     */
    private LocalDate updatetime;

    /**
     * 封面
     */
    private String cover;

    public Book() {}
}