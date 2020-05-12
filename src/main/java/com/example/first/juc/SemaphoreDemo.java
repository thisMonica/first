package com.example.first.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author hu
 * @date 2020/5/12 22:40
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //线程数量,只能固定线程数线执行，释放后，后续线程继续执行
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
           new Thread(()->{
               //acquire()得到
               try {
                   semaphore.acquire();
                   System.out.println(Thread.currentThread().getName()+" 已获得");
                   TimeUnit.SECONDS.sleep(2);
                   System.out.println(Thread.currentThread().getName()+" 已离开");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   semaphore.release();
               }
           }).start();
        }

    }
}
