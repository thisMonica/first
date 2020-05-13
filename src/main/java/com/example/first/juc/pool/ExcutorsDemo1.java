package com.example.first.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hu
 * @date 2020/5/12 23:51
 */
public class ExcutorsDemo1 {

    public static void main(String[] args) {
        //三大方法
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//可伸缩

        try {
            for (int i = 0; i < 100; i++) {
                //使用线程池创建线程
                threadPool3.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，关闭线程
            threadPool3.shutdown();
        }

    }


}



