package com.example.first.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hu
 * @date 2021/3/20 0:11
 * @desc:
 */
public class ThreadPoolTest {


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new ThreadPoolExecutor.AbortPolicy()
        );


        int i = 1;
        ThreadLocal threadLocal = new ThreadLocal();


//        threadLocal.set(i);

        Thread thread = new Thread() {
            @Override
            public void run() {
                ThreadLocal threadLocal1 = new ThreadLocal();
                threadLocal1.set(i + 1);
                System.out.println("main:" + threadLocal.get());
                System.out.println("thread:" + threadLocal1.get());
            }
        };
        thread.start();

//        System.out.println(threadLocal.get());


    }


}
