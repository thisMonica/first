package com.example.first.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author hujiahan
 * @date 2020/1/31 14:45
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        Map map1 = new Hashtable();
        map.put(null, null);
        map.put("a", 1);
        map.put("a", 1);
        map.put("a", 1);
        Class<Type> typeClass = Type.class;
        try {
            Type type = typeClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (String key : map.keySet()) {
            System.out.println("key:" + key + ",value:" + map.get(key));
        }

        for (Map.Entry<String, Integer> entries : map.entrySet()) {
            System.out.println("key:" + entries.getKey() + ",value:" + entries.getValue());
        }
    }

}
