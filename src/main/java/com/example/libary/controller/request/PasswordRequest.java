package com.example.libary.controller.request;

import lombok.Data;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/21 12:40
 */
@Data
public class PasswordRequest {
    private String username;
    private String password;
    private String newPass;
}

