package com.example.first.api;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author hu
 * @date 2020/4/14 22:24
 */
@Slf4j
public class HttpApi {

    static OkHttpClient okHttpClient = new OkHttpClient();

    final static String URL = "https://bch-chain.api.btc.com/v3/block/latest";

    public static void main(String[] args) {

//        Request request = new Request.Builder()
//                .url(URL)
//                .build();
//
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
//            log.info(jsonObject.toJSONString());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Request.Builder reqBuild = new Request.Builder();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://blockchain.info/unspent")
                .newBuilder();

        urlBuilder.addQueryParameter("active", "14XrqX76DRejbhbhdGRRJ395dye4DoPzgJ");
        reqBuild.url(urlBuilder.build());
        Request request = reqBuild.build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String res = response.body().string();
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
//            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
//            log.info(jsonObject.toJSONString());


    }


}
