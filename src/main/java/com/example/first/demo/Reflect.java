package com.example.first.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hujiahan
 * @date 2020/2/1 12:05
 */
public class Reflect {

    public static void main(String[] args) {
        //第一种获取对象
        Class a = Integer.class;
        Class obj = Object.class;
        System.out.println(a.getName() + "," + obj.getName());

        //第二种获取对象
        Type type = new Type();
        Class t = type.getClass();
        System.out.println(t.getName());

//        try {
//            //第三种获取对象
//            Class o = Class.forName("java.lang.Object");
//            System.out.println(o.getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            Method say = t.getMethod("say", String.class);
            say.invoke(t.newInstance(), "123");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
