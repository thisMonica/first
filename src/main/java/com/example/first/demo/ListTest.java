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
        List<String> arrayList = new ArrayList();
        String[] strings = arrayList.toArray(args);
//        arrayList.add("a");
//        arrayList.add("b");
//        arrayList.add("c");
//        arrayList.add("d");
//        arrayList.add("e");

//        Set set = new HashSet();
//        set.add(1);
//        set.add(1);
//        System.out.println(set);


        printDefaultCapacityList();
        printEmptyCapacityList();

    }


    public static void printDefaultCapacityList() {
        ArrayList defaultCapacity = new ArrayList();
        System.out.println(
                "default 初始化长度：" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
                "default add 之后 长度：" + getCapacity(defaultCapacity));
    }

    public static void printEmptyCapacityList() {
        ArrayList emptyCapacity = new ArrayList(0);
        System.out.println(
                "empty 初始化长度：" + getCapacity(emptyCapacity));

        emptyCapacity.add(1);
        System.out.println(
                "empty add 之后 长度：" + getCapacity(emptyCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // 获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            // 开启访问权限
            field.setAccessible(true);
            // 把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
