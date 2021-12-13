package com.example.first.interceptor;

import com.example.first.model.ResultJson;
import com.example.first.utils.error.ErrorResult;
import com.example.first.utils.error.ServiceError;
import kotlin.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hu
 * @date 2021/7/13 0:53
 * @desc:
 */
//@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof ResultJson){
            ResultJson result = (ResultJson) body;
            result.setCode("100000000");
        }

        return body;
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        String msg = ex.getMessage();
        String nowMsg = msg + "我是异常";

        return nowMsg;
    }


}
