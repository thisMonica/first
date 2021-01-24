package com.example.first.designPattern.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * @author hu
 * @date 2020/8/28 10:09
 * @Description:
 */
public class HelloDynamicProxy {


    interface Hello {
        void morning(String name);
    }


    InvocationHandler handler;
    public HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }
    public void morning(String name) throws Throwable {
        handler.invoke(
                this,
                Hello.class.getMethod("morning", String.class),
                new Object[] { name });
    }


}
