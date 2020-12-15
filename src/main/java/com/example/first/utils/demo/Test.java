package com.example.first.utils.demo;

import java.io.InputStream;
import java.net.URL;

/**
 * @author hu
 * @date 2020/8/20 15:33
 */
public class Test {


    public static void main(String[] args) {
//        URL res = Test.class.getClassLoader().getResource("my.keystore");
//        System.out.println(res);
        InputStream input = Test.class.getResourceAsStream("/my.keystore");
        System.out.println(input);
    }
}
