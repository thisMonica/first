package com.example.first.designPattern.factory.simpleFactory.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:36
 */
public class CheesePizza extends Pizza{


    @Override
    public void prepare() {
        System.out.println("给制作奶酪披萨准备原材料");
    }

}
