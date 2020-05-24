package com.example.first.Thread;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.currentThread;

/**
 * @author hu
 * @date 2020/5/12 12:30
 */
public class ThreadTest {

    static class Thread1 extends Thread {

        private int i = 0;

        @Override
        public void run() {
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " is running: " + i);
            }
        }
    }

    public static void main(String[] args) {
//        new Thread1().start();
        new Thread() {
            @Override
            public void run() {

                System.out.println("11:" + currentThread().getName());
            }
        }.start();


        new Runnable() {
            @Override
            public void run() {
                System.out.println("22:"+currentThread().getName());
            }
        }.run();

        System.out.println(currentThread().getName());
    }
}
