package com.example.first.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.first.entity.User;
import com.example.first.model.ResultJson;
import com.example.first.utils.PropertiesUtils;
import com.example.first.utils.RsaAndAes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hu
 * @date 2020/4/19 1:57
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @GetMapping("/test1")
    public ResultJson<Object> queryAll() {

        System.out.println(PropertiesUtils.publicKey);
        System.out.println(PropertiesUtils.privateKey);
//        System.out.println(PropertiesUtils.publicKey);
        String json = RsaAndAes.encode("1");
        JSONObject res = JSONObject.parseObject(json);
        String sign = res.getString("sign");
        String param = res.getString("param");
        log.info("sign:{}", sign);
        log.info("param:{}", param);
        String params = RsaAndAes.dncode(sign, param);
        log.info("content:{}", params);
        return ResultJson.toSuccess(params);
    }


}
