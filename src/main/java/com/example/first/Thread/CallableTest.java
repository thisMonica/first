package com.example.first.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hu
 * @date 2020/5/12 12:31
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallbale myCallbale = new MyCallbale();
        FutureTask futureTask = new FutureTask(myCallbale);
        new Thread(futureTask,"thread1").start();
        String  callable = (String) futureTask.get();
        System.out.println(callable);
    }

    static class MyCallbale implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello callable";
        }
    }

}



