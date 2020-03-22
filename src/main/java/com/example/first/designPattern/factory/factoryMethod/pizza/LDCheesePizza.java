package com.example.first.designPattern.factory.factoryMethod.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:36
 */
public class LDCheesePizza extends Pizza {


    @Override
    public void prepare() {
        setName("伦敦的奶酪披萨");
        System.out.println("给伦敦奶酪披萨准备原材料");
    }

}
