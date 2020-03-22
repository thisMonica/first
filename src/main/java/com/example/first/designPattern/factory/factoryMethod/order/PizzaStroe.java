package com.example.first.designPattern.factory.factoryMethod.order;

import com.example.first.designPattern.factory.simpleFactory.order.OrderPizza2;

/**
 * @author hu
 * @date 2020/3/22 15:47
 */
//相当于客户端，发出订购任务
public class PizzaStroe {

    public static void main(String[] args) {
        //北京的披萨
        new BJOrderPizza();
    }


}
