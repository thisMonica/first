package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest2 {


    //饿汉式(静态代码块)
    static class Singleton {
        //1、构造器私有化，外部能new()
        private Singleton() {

        }

        //2、本类内部创建对象实例
        private static Singleton instance;

        //在静态代码块中创建单例对象
        static {
            instance = new Singleton();
        }

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
