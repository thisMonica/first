package com.example.first.designPattern.singleton;

/**
 * @author hu
 * @date 2020/3/22 13:21
 */
public class SingletonTest6 {


    //双重检查应用实例，推荐使用
    static class Singleton {

        private static volatile Singleton instance;

        //2、构造器私有化，外部能new()
        private Singleton() {

        }

        //3、提供一个公有的静态方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
        //同时保证了效率，推荐使用
        public static Singleton getInstance() {
            if (instance == null){
                synchronized (Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                        }
                }
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
