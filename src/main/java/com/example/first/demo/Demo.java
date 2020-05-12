package com.example.first.demo;

import com.example.first.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author hu
 * @date 2020/3/23 19:05
 */
@Slf4j
public class Demo {

    static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (Demo.class) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (Demo.class) {
                    counter--;
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}", counter);
    }
}
