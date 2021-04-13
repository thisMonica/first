package com.example.first.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author hu
 * @date 2021/3/21 0:54
 * @desc:试用api
 */
public class QueueTest {

    /**
     * @formatter:off
     *
     *  BlockingQueue的方法
     *  放入数据
     *      add(object):如果是有界队列，队列满了之后，添加时，会抛异常IllegalStateException
     *      offer(object):如果是有界队列，队列满了之后，添加时，不会抛异常，会返回false
     *      put(object):队列的容量已满时，线程会一直阻塞，队列满的时候一直等待直到中断异常
     *  获取数据
     *      poll(time):获取队列头的数据，并删除该数据（将该位置数据置为null）。如果队列已经空了，那么直接返回 null
     *      poll(long timeout, TimeUnit unit):判断队列是否为空，如果为空等待设置的时间，等待时间超过设置的时间。直接返回null
     *      take():take 方法，如果队列为空，会进入阻塞状态
     *      drainTo():
     *
     *  ArrayBlockingQueue方法
     *      获取数据
     *      peek()方法用于返回队列的头部。它检索但不删除此队列的头。如果队列为空，则此方法返回null
     *
     *@formatter:on
     */

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);

        queue.add(1);
        queue.add(2);
//        int size = queue.size();
        int size = 3;

        for (int i = 0; i < size; i++) {
            queue.put(1);
        }

        for (int i = 0; i < size; i++) {

            System.out.println(queue.take());
        }
    }


}
