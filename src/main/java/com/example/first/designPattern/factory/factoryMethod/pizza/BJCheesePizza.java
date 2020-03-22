package com.example.first.designPattern.factory.factoryMethod.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:36
 */
public class BJCheesePizza extends Pizza {


    @Override
    public void prepare() {
        setName("北京的奶酪披萨");
        System.out.println("给北京奶酪披萨准备原材料");
    }

}
