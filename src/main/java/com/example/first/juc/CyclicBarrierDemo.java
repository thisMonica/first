package com.example.first.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author hu
 * @date 2020/5/12 21:38
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //加法计数器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("end...");
        });
        for (int i = 0; i < 7; i++) {
            final int tmep = i;
            //lambda能操作到i吗?lambda表达式里是个类，拿不到上面的变量
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + tmep + " go out");
                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
