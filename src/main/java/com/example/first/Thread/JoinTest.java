package com.example.first.Thread;

/**
 * @author hu
 * @date 2021/3/21 15:03
 * @desc:
 */
public class JoinTest {


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {


            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":1");
            });
            thread.start();
            thread.join();

            Thread thread2 = new Thread() {

                @Override
                public void run() {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":2");
                }
            };

            thread2.start();
            thread2.join();

            Thread thread3 = new Thread() {

                @Override
                public void run() {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":3");
                }
            };
            thread3.start();
            thread3.join();
        }
    }


}
