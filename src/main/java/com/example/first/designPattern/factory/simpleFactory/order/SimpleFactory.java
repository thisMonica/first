package com.example.first.designPattern.factory.simpleFactory.order;

import com.example.first.designPattern.factory.simpleFactory.pizza.CheesePizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.GreekPizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.PepperPizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.Pizza;

/**
 * @author hu
 * @date 2020/3/22 15:57
 */
//简单工厂类
public class SimpleFactory {

    //根据orderType返回对应的Pizza对象
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else if ("pepper".equals(orderType)) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;

    }

    //简单工厂模式也叫静态工厂模式
    public static Pizza createPizza2(String orderType) {

        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else if ("pepper".equals(orderType)) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;

    }

}
