package com.example.first.demo;

/**
 * @author hu
 * @date 2020/7/2 0:51
 */
public class LoadingDemo {

    private static  String a = "a";
    private static String b = "b";

    public LoadingDemo() {
        System.out.println("1");
    }

    public LoadingDemo(String a, String b) {
        System.out.println(2);
        this.a = a;
        this.b = b;
    }



    public static void main(String[] args) {
        LoadingDemo l = new LoadingDemo(a,b);
    }


}
