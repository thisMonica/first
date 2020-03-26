package com.example.first.designPattern.singleton;

import com.example.first.entity.User;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest8 {



    //使用枚举，可以实现单例，推荐使用
    enum Singleton {

        //创建一个枚举对象，该对象天生为单例
        INSTANCE;

        private User user;

        //私有化枚举的构造函数
        private Singleton() {
            user = new User();
        }

        public User getInstnce() {
            return user;
        }

        //对外暴露一个获取User对象的静态方法
        public static User getInstance() {
            return Singleton.INSTANCE.getInstnce();
        }


    }

    public static void main(String[] args) {
        User user = Singleton.INSTANCE.getInstnce();
        User user1 = Singleton.INSTANCE.getInstnce();
        System.out.println(user == user1);
        System.out.println("instance:" + user.hashCode());
        System.out.println("instance1:" + user1.hashCode());
    }

}
