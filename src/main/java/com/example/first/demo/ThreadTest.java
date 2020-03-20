package com.example.first.demo;

import static java.lang.Thread.sleep;

/**
 * @author hujiahan
 * @date 2020/1/30 14:45
 */
public class ThreadTest {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                try {
                    sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long endTime = System.currentTimeMillis();
                System.out.println(String.format("%d ms", endTime - startTime));

            }
        }).start();

    }
}
