package com.example.first.okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.util.*;

/**
 * @author hu
 * @date 2020/10/26 1:20
 * @desc:
 */
public class ParamsInterceptor1 implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        RequestBody body = request.body();
        JSONObject jsonObject = new JSONObject();
        if ("POST".equals(request.method())) {
            if (body instanceof FormBody) {
                FormBody formBody = (FormBody) body;
                for (int i = 0; i < (formBody).size(); i++) {
                    jsonObject.put(formBody.encodedName(i), formBody.encodedValue(i));
                }
            }
        }
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        bodyBuilder.addEncoded("data",jsonObject.toJSONString());
        request = requestBuilder.build();
        FormBody formBody2 = (FormBody) request.body();
        for (int i = 0; i < formBody2.size(); i++) {
            System.out.println(formBody2.encodedName(i)+":"+formBody2.encodedValue(i));
        }
        return chain.proceed(request);
    }

    public static String requestBodyToString(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }


}



