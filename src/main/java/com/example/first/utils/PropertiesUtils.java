package com.example.first.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hu
 * @date 2020/4/19 11:52
 */
@Component
@PropertySource("classpath:application.properties")
public class PropertiesUtils {


    public static String publicKey;

    public static String privateKey;

    @Value("${callback.rsa.publicKey}")
    public void setPublicKey(String publicKey) {
        PropertiesUtils.publicKey = publicKey;
    }

    @Value("${callback.rsa.privateKey}")
    public void setPrivateKey(String privateKey) {
        PropertiesUtils.privateKey = privateKey;
    }


    public static void main(String[] args) {

    }


}


