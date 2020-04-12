package com.example.first.demo;

import com.example.first.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hu
 * @date 2020/3/23 19:05
 */
@Slf4j
public class Demo{

    public boolean test(Object anObject){
//        String
//                Object
        if (this instanceof  Demo){
            return true;
        }
        if (this == anObject) {
            return true;
        }
        return false;

    }


    public static void main(String[] args) {

        String a = null;
        log.error("出现异常");
        System.out.println(a.toString());



    }
}
