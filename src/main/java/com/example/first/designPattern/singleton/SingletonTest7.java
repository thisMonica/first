package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest7 {


    //静态内部类完成，推荐使用
    static class Singleton {

        private static volatile Singleton instance;

        //2、构造器私有化，外部能new()
        private Singleton() {

        }

        //3、静态内部类，该类中有一个静态属性Singleton
        private static class SingletonInstance {
            private static final Singleton INSTANCE = new Singleton();
        }


        //4、提供一个公有的静态方法，直接返回
        public static Singleton getInstance() {
            return SingletonInstance.INSTANCE;
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
