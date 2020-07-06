package com.example.first.demo;

/**
 * @author hu
 * @date 2020/7/2 0:51
 */
public class LoadingDemo {

    public static String a = "静态变量";
    public static String b = "b";
    public static String c = "c";

    public LoadingDemo() {
        System.out.println("父类无参构造方法");

    }

    public LoadingDemo(String a, String b) {
        System.out.println("父类有参构造方法");
        this.a = a;
        this.b = b;
    }

    {
        System.out.println("父类普通代码块");

    }

    static {
        System.out.println("父类静态代码块");
    }

    public static void fun() {
        System.out.println("父类静态方法");
    }

    public static void main(String[] args) {
        System.out.println("----------");
//        LoadingDemo l = new LoadingDemo(a, b);
        LoadingDemo l = new LoadingDemo();
    }


}
