package com.neu.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

// 全局异常处理类
//@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public String exceptionHandler(Exception e){
        if (e instanceof MaxUploadSizeExceededException)
            return "文件大小超过规定";
        return "服务器错误，请联系贠朵朵17793583203，如不在，请联系罗文龙17784474117";
    }
}
