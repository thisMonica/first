package com.example.first.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 2020/2/13 22:22
 */
public class ListTest {

    public static void main(String[] args) {
//        List<String> arrayList = new ArrayList();
//        arrayList.add("a");
//        arrayList.add("b");
//        arrayList.add("c");
//        arrayList.add("d");
//        arrayList.add("e");

//        Set set = new HashSet();
//        set.add(1);
//        set.add(1);
//        System.out.println(set);


        Byte a = 127;
        Long b = 123L;
        Double c = 0.9123239d;
        float d = 0.91239234f;

//        Type type = new Type();
//        Type type1 = new Type(a, b, c, d);
        try {
            Type type2 = Type.class.newInstance();
            Class<Type> typeClass = Type.class;
            Field a1 = typeClass.getDeclaredField("a");
            System.out.println(a.toString());
            a.toString();
        } catch (InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        type.();

    }
}
