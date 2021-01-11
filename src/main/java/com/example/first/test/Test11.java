package com.example.first.test;

import java.time.LocalDateTime;

/**
 * @author hu
 * @date 2020/12/28 22:02
 * @desc:
 */
public class Test11 {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime now1 = LocalDateTime.now();
            System.out.println(now + "/n" + now1);
            System.out.println(now.isEqual(now1));
        }
    }
}
