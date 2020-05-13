package com.example.first.java8.TestLambda;

import java.util.*;
import java.util.function.Consumer;

/**
 * @formatter:off
 * 一、Lambda表达式的基础语法:Java8中引入了一个新的操作符"->"，该操作符称为箭头操作符或Lambda操作符
 *  箭头操作符将Lambda表达式拆分为两个部分
 *  左侧：Lambda表达式的参数
 *  右侧：Lambda表达式所需执行的功能，即Lambda体
 *  语法格式：无参数，无返回值
 *          ()->System.out.println("Hello Lambda!")
 *  语法格式：有一个参数，无返回值
 *          (x) -> System.out.println(x)
 *  语法格式三：有一个参数，小括号可以省略不写
 *          x -> System.out.println(x)
 *  语法格式四：有两个参数，有返回值，并且Lambda体中有多条语句，此时要用大括号
 *          Comparator<Integer> com = (x, y) -> {
 *             System.out.println("x" + x + " y" + y);
 *             return Integer.compare(x, y);
 *         };
 *  语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *      Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *  语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JWM编译器通过上下文推断出数据类型，即"类型推断"
 *
 *   左右遇一括号省
 *   左侧判断类型省略
 *
 *二、Lambda表达式需要"函数式接口"支持
 *  函数式接口：接口只有一个抽象方法的接口，称为函数式接口 。可以使用注解@FunctionalInterface修饰
 *              就可以检查是否是函数式接口
 *
 * @formatter:on
 */
public class TestLambda2 {

    public void test1() {
        int num = 0;//Java7以前必须final修饰，Java8默认final修饰
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };
        r1.run();
        System.out.println("---------");
        Runnable r2 = () -> System.out.println("Hello World!");
        r2.run();
    }

    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con1 = x -> System.out.println(x);
        con.accept("Hello World!");
        con1.accept("Hello World!");
    }

    public void test3() {
        Comparator<Integer> com = (Integer x, Integer y) -> {
            System.out.println("x" + x + " y" + y);
            return Integer.compare(x, y);
        };
    }

    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }


    //需求：对一个数进行运算
    public void test5() {
        Integer num = calc(100, x -> x * x);
        System.out.println(num);

    }
    public Integer calc(Integer num,MyFun mf){

        return mf.getValue(num);
    }

    public static void main(String[] args) {
        TestLambda2 testLambda2 = new TestLambda2();
        testLambda2.test1();
    }


}
