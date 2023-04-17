package com.example.libary.exception;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/17 22:10
 */
public class ServiceException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }
}
