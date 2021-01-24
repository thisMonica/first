package com.example.first.test;

import java.time.LocalDateTime;

/**
 * @author hu
 * @date 2020/12/28 22:02
 * @desc:
 */
public class Test11{

    public static void main(String[] args){
        System.out.println("演示开始");
        new Thread(()->{
            A.a();
        }).start();
        new Thread(()->{
            B.b();
        }).start();
    }

    static class A{
        public static synchronized void a(){
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                e.printStackTrace();
            }


            System.out.println("我拿到锁a了，锁b快到碗里来！");

            B.b();
        }
    }

    static class B{
        public static synchronized void b(){
            System.out.println("我拿到锁b了，锁a快到碗里来！");
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                e.printStackTrace();
            }
            A.a();
        }
    }
}
