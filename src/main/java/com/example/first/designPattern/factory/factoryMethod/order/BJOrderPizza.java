package com.example.first.designPattern.factory.factoryMethod.order;

import com.example.first.designPattern.factory.factoryMethod.pizza.BJCheesePizza;
import com.example.first.designPattern.factory.factoryMethod.pizza.BJPepperPizza;
import com.example.first.designPattern.factory.factoryMethod.pizza.Pizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.CheesePizza;
import com.example.first.designPattern.factory.simpleFactory.pizza.GreekPizza;

/**
 * @author hu
 * @date 2020/3/22 18:55
 */
public class BJOrderPizza extends OrderPizza {


    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if ("pepper".equals(orderType)) {
            pizza = new BJPepperPizza();
        } else if ("cheese".equals(orderType)) {
            pizza = new BJCheesePizza();
        }
        return pizza;
    }
}
