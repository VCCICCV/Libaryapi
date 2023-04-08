package com.example.libary.entity;

/**
 * @PROJECT_NAME Libary
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 15:38
 */
import lombok.Data;// getter setter
@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private String sex;
    private String phone;
    private String address;
}
