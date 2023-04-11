package com.example.libary.entity;

/**
 * @PROJECT_NAME Libary
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 15:38
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;// getter setter

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private String sex;
    private String phone;
    private String address;
    @JsonFormat(pattern = "yyy-MM-dd0",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyy-MM-dd0",timezone = "GMT+8")
    private Date updatetime;
}
