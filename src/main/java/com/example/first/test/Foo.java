package com.example.first.test;

import java.util.concurrent.Semaphore;

/**
 * @author hu
 * @date 2020/6/21 13:37
 */
public class Foo {

//    public Foo() throws InterruptedException {
//
//
//        first(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("ONE");
//            }
//        });
//
//        second(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("TWO");
//            }
//        });
//
//        third(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("THREE");
//            }
//        });
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        Thread A = new Thread(printFirst);
//        A.start();
//        A.join();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        Thread B = new Thread(printSecond);
//        B.start();
//        B.join();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        Thread C = new Thread(printThird);
//        C.start();
//        C.join();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Foo foo = new Foo();
//    }

    public Semaphore seam_first_two = new Semaphore(0);

    public Semaphore seam_two_second = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        seam_first_two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        seam_first_two.acquire();
        printSecond.run();
        seam_two_second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        seam_two_second.acquire();
        printThird.run();
    }


    public static void main(String[] args) {
        Foo foo = new Foo();
    }
}
