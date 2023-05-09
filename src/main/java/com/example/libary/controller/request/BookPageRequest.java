package com.example.libary.controller.request;

import lombok.Data;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/7 10:56
 */
@Data
public class BookPageRequest extends BaseRequest{
    private String name;
    private String bookNo;
}
