package com.example.libary.controller.request;

import lombok.Data;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/9 16:17
 */
@Data
public class UserPageRequest extends BaseRequest{
    private String name;
    private String phone;

}
