package com.example.first.test;

import com.example.first.annotation.MyAnno;

/**
 * @author hu
 * @date 2020/10/15 1:26
 */
public class Test<T> {


    @MyAnno("12")
    public static void test() throws NoSuchFieldException {
        System.out.println(MyAnno.class.getField("vaule"));

    }

    public static void main(String[] args) throws NoSuchFieldException {
        test();

    }

    T get(){

        System.out.println(11);
        return (T) "";
    }

}
