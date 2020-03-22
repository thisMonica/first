package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest3 {


    //懒汉式(不加锁)
    static class Singleton {


        private static Singleton instance;

        //2、构造器私有化，外部能new()
        private Singleton() {

        }

        //3、提供一个共有的静态方法，当使用到该方法时，才去创建instance
        public static Singleton getInstance() {
            if (instance == null){
                instance = new Singleton();
            }
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
