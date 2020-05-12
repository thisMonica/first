package com.example.first.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hu
 * @date 2020/5/12 21:25
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " go out");
                countDownLatch.countDown();//数量-1
            }).start();
        }
        countDownLatch.await();//等待计数器归零，然后再向下执行
        System.out.println("end...");
    }
}
