package com.example.first.controller;

import com.example.first.config.TestConfig;
import com.example.first.model.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hu
 * @date 2021/10/16 13:18
 * @desc:
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class ConfigController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/get")
    public ResultJson<Object> getConfig() {
        String a = testConfig.getA();
        String b = testConfig.getB();
        String c = testConfig.getC();
        testConfig.getABC();
        return ResultJson.toSuccess(testConfig);
    }


}
