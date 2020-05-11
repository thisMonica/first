package com.example.first.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Tom Cheng
 */
public class ServicePoolManager {
    private ServicePoolManager() {
    }

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static Future<?> run(Runnable runnable) {
        return pool.submit(runnable);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
