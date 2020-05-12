package com.example.first.juc;

/**
 * @author hu
 * @date 2020/5/12 12:30
 */
public class RunnableTest {

    static class Thread1 implements Runnable {
        private int i = 0;

        @Override
        public void run() {
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " is running: " + i);
            }
        }
    }


    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        new Thread(t1, "线程1").start();
        new Thread(t2, "线程2").start();
        new Thread(t3, "线程2").start();

    }

}
