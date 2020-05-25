package com.example.first.Thread;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

/**
 * @author hu
 * @date 2020/5/24 16:14
 */
@Slf4j
public class StartRun {


    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info(Thread.currentThread().getName() + ":running...");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        log.info(Thread.currentThread().getName() + ":异步");
    }


}
