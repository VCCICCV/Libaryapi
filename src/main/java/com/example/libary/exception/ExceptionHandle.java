package com.example.libary.exception;

import cn.hutool.core.util.StrUtil;
import com.example.libary.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/17 17:58
 */
// 全局异常处理
@RestControllerAdvice
@Slf4j

public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        return Result.error("系统错误");
    }

    @ExceptionHandler (value = ServiceException.class)
    public Result serviceExceptionError(ServiceException e) {
        log.error("业务异常", e);
        return Result.error(e.getMessage());
    }

    // @ExceptionHandler (value = ServiceException.class)
    // public Result serviceExceptionError(ServiceException e) {
    //     log.error("业务异常", e);
    //     String code = e.getCode();
    //     if (StrUtil.isNotBlank(code)) {
    //         return Result.error(code, e.getMessage());
    //     }
    //     return Result.error(e.getMessage());
    // }
    // @ExceptionHandler (value = Exception.class)
    // public Result exceptionError(Exception e) {
    //     log.error("系统错误", e);
    //     return Result.error("系统错误");
    // }

}
