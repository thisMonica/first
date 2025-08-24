package com.example.first.algorithm;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交替打印 FooBar
 *
 * @Author hujiahan
 * @Date 2025/5/5 16:55
 * <a>https://leetcode.cn/problems/print-foobar-alternately</a>
 */
public class FooBar {

    private int n;



    public FooBar(int n) {
        this.n = n;
    }

    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphore1.acquire();
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.release();
        }
    }



}
