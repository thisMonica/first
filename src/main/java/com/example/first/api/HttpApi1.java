package com.example.first.api;

import com.alibaba.fastjson.JSONObject;
import com.example.first.okhttp.ParamsInterceptor;
import com.example.first.okhttp.ParamsInterceptor1;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * @author hu
 * @date 2020/4/14 22:24
 */
@Slf4j
public class HttpApi1 {

    static OkHttpClient okHttpClient = new OkHttpClient();


    final static String URL = "http://127.0.0.1/dept/save";

    public static void main(String[] args) {


        //创建连接
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new ParamsInterceptor1()).build();
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(paramsInterceptor).build();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "1");
        jsonObject.put("2", "2");
        jsonObject.put("3", "3");

        FormBody formBody = new FormBody.Builder()
                .addEncoded("deptId","113123")
                .addEncoded("deptNo","212312321")
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();
        //将Request封装为Call
        Call call = client.newCall(request);


        //调用请求,重写回调方法
        try {
            Response response = call.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }


    }


}
