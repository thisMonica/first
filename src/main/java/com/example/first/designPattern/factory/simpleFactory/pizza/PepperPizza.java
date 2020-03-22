package com.example.first.designPattern.factory.simpleFactory.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:36
 */
public class PepperPizza extends Pizza{


    @Override
    public void prepare() {
        System.out.println("给制作胡椒披萨准备原材料");
    }

}
