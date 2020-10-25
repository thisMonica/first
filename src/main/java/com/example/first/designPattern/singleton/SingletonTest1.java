package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest1 {


    //饿汉式(静态变量)
    static class Singleton {
        //1、构造器私有化，外部不能new()
        private Singleton() {

        }

        //2、本类内部创建对象实例
        private final static Singleton instance = new Singleton();

        //3、提供一个共有的静态方法，返回方法实例
        public static Singleton getInstance() {
            return instance;
        }

    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance:" + instance.hashCode());
        System.out.println("instance1:" + instance.hashCode());
    }

}
