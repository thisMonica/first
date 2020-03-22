package com.example.first.designPattern.factory.simpleFactory.order;

import com.example.first.designPattern.factory.simpleFactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hu
 * @date 2020/3/22 15:39
 */
public class OrderPizza {

    //传统方法，没使用设计模式，可以用简单工厂模式
    //构造器
//    public OrderPizza(){
//        Pizza pizza = null;
//        String ordertype;//订购披萨类型
//        do{
//            String orderType = getType();
//            if ("greek".equals(orderType)){
//                pizza = new GreekPizza();
//                pizza.setName("希腊披萨");
//            }else  if ("cheese".equals(orderType)){
//                pizza = new CheesePizza();
//                pizza.setName("奶酪披萨");
//            }else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }


    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = "";//用户输入
        this.simpleFactory = simpleFactory;//设置一个工厂对象
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
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
