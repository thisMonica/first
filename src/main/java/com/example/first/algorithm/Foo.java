package com.example.first.algorithm;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程顺序打印
 *
 * @Author hujiahan
 * @Date 2025/5/5 1:30
 * 力扣 <a>https://leetcode.cn/problems/print-in-order/</a>
 */
public class Foo {

    CountDownLatch countDownLatch1 = new CountDownLatch(1);

    CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        System.out.println("first");
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatch1.await();
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatch1.await();
        countDownLatch2.await();
        printThird.run();
    }

}



