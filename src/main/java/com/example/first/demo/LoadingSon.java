package com.example.first.demo;

/**
 * @author hu
 * @date 2020/7/2 0:51
 */
public class LoadingSon extends LoadingDemo {


    public LoadingSon() {
        System.out.println("子类的无参构造方法");
    }

    public LoadingSon(String a, String b) {
        System.out.println("子类的有参构造方法");
    }

    {
        System.out.println("子类普通代码块");
    }

    static {
        System.out.println("子类静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("LoadingSon loadingSon = new LoadingSon()");
        System.out.println("----------------");
//        LoadingSon loadingSon1 = new LoadingSon(a, b);
        LoadingSon loadingSon = new LoadingSon();
    }


}
