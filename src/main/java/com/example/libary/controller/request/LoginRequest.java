package com.example.libary.controller.request;

import cn.hutool.core.lang.copier.SrcToDestCopier;
import lombok.Data;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/17 11:37
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
