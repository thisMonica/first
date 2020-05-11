package com.example.first.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hu
 * @date 2020/5/2 22:04
 */
public class Test {


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("开始");
        AtomicInteger a = new AtomicInteger();
//5585
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i1 = 0; i1 < 1000000; i1++) {
            threadPool.execute(() -> {

                a.addAndGet(1);
            });
//            System.out.println(Thread.currentThread().getName() + " is running");
        }


//        for (int i1 = 0; i1 < 1000000; i1++) {
//            a.addAndGet(1);
//        }

        System.out.println(a.get());
        threadPool.shutdown();
        System.out.println("异步");
        System.out.println("耗时：" + (System.currentTimeMillis() - l));

        List list = new ArrayList();
        list.get(0).equals(List.class);

    }
}
