package com.example.first.designPattern.proxy;

/**
 * @author hu
 * @date 2020/8/28 10:13
 * @Description:
 */
public class A implements Hello {

    @Override
    public void sayHello(String name) {
        System.out.println(name + " say hello");
    }
}
