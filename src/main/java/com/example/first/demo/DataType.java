package com.example.first.demo;

import java.util.function.Consumer;

/**
 * @author hujiahan
 * @date 2020/2/2 21:31
 */
public class DataType {

    Integer a;

    public void say() {
        System.out.println(a);
    }

    public static void main(String[] args) {
//        DataType dataType = new DataType();
//        dataType.say();


//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        Long h = 2L;
//        int a1 = 321;
//        int b1 = 1;
//        System.out.println(a==a1);
//        System.out.println(a1==b1);
//        System.out.println(c==d);
//        System.out.println(e==f);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g==(a+b));
//        System.out.println(g.equals(a+b));
//        System.out.println(g.equals(a+h));

        //new出来的对象指向堆内存中不同的引用
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println("i == j:" + (i == j));

        //包装类Integer和基本数据类型int比较时，java会自动拆包装为int，
        // 然后进行比较，实际上就变为两个int变量的比较
        Integer i0 = -1000;
        int j0 = -1000;
        System.out.println("i0 == j0:" + (i0 == j0));
        Integer i1 = new Integer(300);
        int j1 = 300;
        System.out.println("i1 == j1:" + (i1 == j1));

        Integer i2 = new Integer(100);//引用在堆内存中
        Integer j2 = 100;//引用在常量池中
        System.out.println("i2 == j2:" + (i2 == j2));

        //对于两个非new生成的Integer对象，进行比较时，
        // 如果两个变量的值在区间-128到127之间，则指向同一个引用
        Integer i3 = 100;
        Integer j3 = 100;
        System.out.println("i3 == j3:" + (i3 == j3));

        //否则就是new出来的，不同的引用
        Integer i4 = 128;
        Integer j4 = 128;
        System.out.println("i4 == j4:" + (i4 == j4));


        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1.intValue());
        System.out.println("var1 == var2:" + (var1 == var2));


    }


    public static void doSomething(Integer integer) {
        integer = new Integer(2);
    }

}
