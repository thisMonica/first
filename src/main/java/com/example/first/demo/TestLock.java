package com.example.first.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hu
 * @date 2020/3/10 15:30
 */
public class TestLock {

    // ReentrantLock为Lock的唯一实现类
    private Lock lock = new ReentrantLock();

    /**
     * 测试使用lock 的 lock()方法 ：如果锁已经被其他线程获取，则等待
     *
     * @param thread
     */
    public void testLock(Thread thread) {
        try {
            // 1.获取锁
            lock.lock();
            System.out.println("线程 " + thread.getName() + " 获取了锁！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程 " + thread.getName() + " 释放了锁！");
            // 必须在 finally 中释放锁，防止死锁
            lock.unlock();
        }
    }

    public void testLockInterruptibly(Thread thread){
        try {
            // 1.获取锁
            lock.lockInterruptibly();
            System.out.println("线程 " + thread.getName() + " 获取了锁！");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("线程 " + thread.getName() + " 释放了锁！");
            // 必须在 finally 中释放锁，防止死锁
            lock.unlock();
        }
    }

    public void testTryLock(Thread thread){
        if(lock.tryLock()){// 如果获取到了锁
            try {
                System.out.println("线程 " + thread.getName() + " 获取了锁！");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("线程 " + thread.getName() + " 释放了锁！");
                // 必须在 finally 中释放锁，防止死锁
                lock.unlock();
            }
        }else {
            // 没有获取到锁
            System.out.println("线程 " + thread.getName() + " 没有获取到锁！");
        }
    }

    public void testTryLock_time_unit(Thread thread){
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){// 如果获取到了锁
                try {
                    System.out.println("线程 " + thread.getName() + " 获取了锁！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("线程 " + thread.getName() + " 释放了锁！");
                    // 必须在 finally 中释放锁，防止死锁
                    lock.unlock();
                }
            }else {
                // 没有获取到锁
                System.out.println("线程 " + thread.getName() + " 没有获取到锁！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        TestLock testLock = new TestLock();
        Thread a = new Thread("A") {
            @Override
            public void run() {
//                // 测试 lock()
                testLock.testLock(Thread.currentThread());
//                // 测试 lockInterruptibly()
//                testLock.testLockInterruptibly(Thread.currentThread());
//                测试 tryLock()
//                testLock.testTryLock(Thread.currentThread());
//                 测试 tryLock(long time, TimeUnit unit)
//                testLock.testTryLock_time_unit(Thread.currentThread());
//                testLock.testTryLock_time_unit(Thread.currentThread());
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                testLock.testTryLock(Thread.currentThread());
            }
        };
        a.start();
        b.start();
    }

}
