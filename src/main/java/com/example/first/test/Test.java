package com.example.first.test;

import com.example.first.annotation.MyAnno;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * @author hu
 * @date 2020/10/15 1:26
 */
public class Test {


    @MyAnno("12")
    public static void test() throws NoSuchFieldException {
        System.out.println(MyAnno.class.getField("vaule"));

    }

    public static void main(String[] args) throws NoSuchFieldException {
        test();

    }

}
