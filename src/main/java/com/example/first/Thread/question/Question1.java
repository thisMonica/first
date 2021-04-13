package com.example.first.Thread.question;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hu
 * @date 2021/3/21 15:11
 * @desc:
 */
public class Question1 {

    /**
     * 3个线程交替打印A、B、C
     */

    static Lock lock = new ReentrantLock();

    static int state = 0;


    public static void main(String[] args) throws InterruptedException {
        new PrintA().start();
        new PrintB().start();
        new PrintC().start();

    }

    static class PrintA extends Thread {

        @Override
        public void run() {

            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    while (state % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    static class PrintB extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    while (state % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    static class PrintC extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    while (state % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + ":C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
