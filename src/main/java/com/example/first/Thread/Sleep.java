package com.example.first.Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hu
 * @date 2020/5/24 16:34
 */
@Slf4j
public class Sleep {

    public void sleep() throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        log.info(Thread.currentThread().getName() + ":" + t1.getState());
        Thread.sleep(500);
        log.info(Thread.currentThread().getName() + ":" + t1.getState());

    }

    public static void yield() throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                Thread.yield();
            }
        };
        t1.start();
        log.info(Thread.currentThread().getName() + ":" + t1.getState());
        Thread.yield();
        log.info(Thread.currentThread().getName() + ":" + t1.getState());

    }


    public static void interrupt() throws InterruptedException {
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("wake up...");
                    e.printStackTrace();
                }
            }
        };
        t2.start();
        Thread.sleep(1000);
        log.info("interrupt....");
        t2.interrupt();
    }


    public static void main(String[] args) throws InterruptedException {
        yield();
    }


}
