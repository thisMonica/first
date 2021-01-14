package com.example.first.test;

import org.springframework.stereotype.Service;

/**
 * @author hu
 * @date 2020/12/15 0:22
 * @desc:
 */
@Service(value = "Test3")
public class Test3<T> implements Test2<T>{

    public static void main(String[] args) {

    }



    public <T> T verify(T a) {
        return a;
    }



}
