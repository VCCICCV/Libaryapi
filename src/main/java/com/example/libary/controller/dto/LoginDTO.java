package com.example.libary.controller.dto;

import lombok.Data;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/17 17:04
 */
@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String phone;
    private String email;
}
