package com.example.first.juc.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hu
 * @date 2020/5/13 23:03
 */
public class ThreadPoolExcutorDemo {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,//线程池中的核心线程数量
                5,//当前线程池正在运行的最大线程数量
                3,//超过 corePoolSize 线程数量的线程最大空闲时间
                TimeUnit.SECONDS,//keepAliveTime单位
                new LinkedBlockingDeque<>(3),//创建工作队列，用于存放提交的等待执行任务
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );

        //四种拒绝策略
        // ThreadPoolExecutor.AbortPolicy() 对列满了，如果还有进程来，抛出异常
        // ThreadPoolExecutor.CallerRunsPolicy() 哪个线程过来的，就哪个线程处理那个满了之后的线程
        // ThreadPoolExecutor.DiscardPolicy() 对列满了，不会抛出异常，会丢掉任务
        // ThreadPoolExecutor.DiscardOldestPolicy() 对列满了，尝试和最早的竞争，不会抛出异常
        //最大承载：对列容量+最大线程数
        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //那么问题来了，最大线程到底该如何定义
        //1、cpu密集型，几核，就是几，可以保持cpu的效率 ，windows上查看cpu核心数量，用任务管理器或者管理里的设备管理器都可以
        //使用代码: Runtime.getRuntime().availableProcessors();
        //2、IO密集型,判断程序中十分耗IO的线程数，设置大于该线程数即可


    }

}
