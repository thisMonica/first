package com.example.first.designPattern.factory.simpleFactory.order;

/**
 * @author hu
 * @date 2020/3/22 15:47
 */
//相当于客户端，发出订购任务
public class PizzaStroe {

    public static void main(String[] args) {
//        new OrderPizza();传统方式

        //使用简单工厂模式
//        new OrderPizza(new SimpleFactory());
//        System.out.println("退出程序!!!");

        new OrderPizza2();
        System.out.println("退出程序!!!");

    }


}
