package com.example.first.designPattern.factory.factoryMethod.order;

import com.example.first.designPattern.factory.factoryMethod.pizza.LDCheesePizza;
import com.example.first.designPattern.factory.factoryMethod.pizza.LDPepperPizza;
import com.example.first.designPattern.factory.factoryMethod.pizza.Pizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.CheesePizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.GreekPizza;

/**
 * @author hu
 * @date 2020/3/22 18:57
 */
public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if ("pepper".equals(orderType)) {
            pizza = new LDPepperPizza();
        } else if ("cheese".equals(orderType)) {
            pizza = new LDCheesePizza();
        }
        return pizza;
    }
}
