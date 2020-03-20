package com.example.first.demo;

/**
 * @author hujiahan
 * @date 2020/1/16 10:49
 */
public class Win implements Runnable {

    private static final int MAX = 50;

    private int index = 1;


    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + "的号码是：" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final Win win = new Win();

        Thread thread1 = new Thread(win, "一号窗口");
        Thread thread2 = new Thread(win, "二号窗口");
        Thread thread3 = new Thread(win, "三号窗口");
        Thread thread4 = new Thread(win, "四号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
