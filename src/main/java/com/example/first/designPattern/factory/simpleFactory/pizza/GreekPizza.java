package com.example.first.designPattern.factory.simpleFactory.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:38
 */
public class GreekPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("给制作希腊披萨准备原材料");
    }
}
