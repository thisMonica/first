package com.example.first.juc;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author hu
 * @date 2020/5/12 22:57
 */
public class QueueDemo {


    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();


    }


    //添加或删除数量超过队列大小，会抛异常
    public static void test1(){
        //阻塞队列，FIFO(先进先出)
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("2");
        arrayBlockingQueue.add("3");
        System.out.println(arrayBlockingQueue.element());//查看队首元素
        //java.lang.IllegalStateException: Queue full
        //arrayBlockingQueue.add("4");
        System.out.println(arrayBlockingQueue.remove());
    }


    //添加或删除数量超过队列大小，会返回异常
    public static void test2(){
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("1");
        arrayBlockingQueue.offer("2");
        arrayBlockingQueue.offer("3");
        System.out.println(arrayBlockingQueue.offer("4"));//false,不抛出异常
        System.out.println(arrayBlockingQueue.peek());//检测队首元素
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        System.out.println(arrayBlockingQueue.poll());//null,不抛出异常
    }

    //等待，阻塞(一直阻塞)
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
//        arrayBlockingQueue.put("d");//超过队列大小，一直阻塞
        System.out.println(arrayBlockingQueue.poll());
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
//        arrayBlockingQueue.take();//没有这个元素，一直阻塞

    }

    //等待，阻塞(一直阻塞)
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
//        arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS);//等待超过超时时间2s就退出
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll(2,TimeUnit.SECONDS);//等待超过超时时间2s就退出

    }

}

