package com.example.libary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/13 22:46
 */
@Data
public class BaseEntity {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 创建时间
     */
    @JsonFormat (pattern = "yyy-MM-dd",timezone = "GMT+8")
    private LocalDate createtime;

    /**
     * 更新时间
     */
    @JsonFormat (pattern = "yyy-MM-dd",timezone = "GMT+8")
    private LocalDate updatetime;


}
