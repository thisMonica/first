package com.example.first.designPattern.factory.factoryMethod.order;

import com.example.first.designPattern.factory.factoryMethod.pizza.Pizza;
import com.example.first.designPattern.factory.simpleFactory.order.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hu
 * @date 2020/3/22 15:39
 */
public abstract class OrderPizza {

    //定义一个抽象方法createPizza，让各个子类自己实现
    abstract Pizza createPizza(String orderType);

    //构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType;//订购披萨类型
        do {
            orderType = getType();
            pizza = createPizza(orderType);//抽象方法，由工厂子类完成
            if (pizza != null) {//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }


    //写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza type:");
        String str = null;
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}
