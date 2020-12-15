package com.example.first.Thread;

/**
 * @author hu
 * @date 2020/5/28 12:37
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                interrupt();
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
                boolean interrupted = interrupted();
                System.out.println(interrupted);
            }
        };
        thread.start();

    }


}
