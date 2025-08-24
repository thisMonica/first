package com.example.first.juc;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CompletableFuture demo
 *
 * @Author hujiahan
 * @Date 2025/8/24 16:52
 */
public class CompletableFutureDemo {

   static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            12,13,1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(13),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void test() throws ExecutionException, InterruptedException {
        long statTime = System.currentTimeMillis();

        List<CompletableFuture<Long>> futures = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            int finalI = i;
            CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> task(finalI), threadPoolExecutor);
            futures.add(completableFuture);
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        voidCompletableFuture.get();

        System.out.println((System.currentTimeMillis() - statTime));
        System.out.println((System.currentTimeMillis() - statTime)/ 2000);
    }

    public static long task(int finalI) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        int size = threadPoolExecutor.getQueue().size();
        int poolSize = threadPoolExecutor.getPoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        long taskCount = threadPoolExecutor.getTaskCount();
        System.out.println("name:" + name + ":" + finalI + ", queue.size:" + size + ", poolSize:" + poolSize + ", activeCount:" + activeCount + ", taskCount:" + taskCount);
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();
    }

}
