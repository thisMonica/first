package com.example.first.config;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hu
 * @date 2021/10/16 1:25
 * @desc:
 */
@Component
@ConfigurationProperties(prefix = "abc.config")
@Data
public class TestConfig {

    private String a;

    private String b;

    private String c;

    public String getABC() {

        return a + b + c;

    }


}
