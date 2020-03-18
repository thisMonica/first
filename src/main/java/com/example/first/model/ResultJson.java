package com.example.first.model;

import lombok.Data;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 18:03
 */
public class ResultJson<T> {

    private String code;
    private T data;

    public ResultJson(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public static ResultJson toError(String code) {
        return new ResultJson(code, (Object)null);
    }

    public static ResultJson toSuccess(Object data) {
        return new ResultJson("0", data);
    }

    public static ResultJson toSuccess() {
        return new ResultJson("0", (Object)null);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}