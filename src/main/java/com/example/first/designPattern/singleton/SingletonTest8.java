package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest8 {


    //使用枚举，可以实现单例，推荐使用
    enum  Singleton {
        INSTANCE;

    }

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance == instance1);
        System.out.println("instance:" + instance.hashCode());
        System.out.println("instance1:" + instance.hashCode());
    }

}
