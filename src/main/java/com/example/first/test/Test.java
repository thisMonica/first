package com.example.first.test;

import com.example.first.entity.Dept;
import com.example.first.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author hu
 * @date 2020/5/20 23:59
 */
public class Test {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "1");
        map.put("1", null);
        map.put("1", "131231");
        System.out.println(map);
        System.out.println(map.get(null));
        System.out.println(map.get("21212"));
        map.clear();
        System.out.println();

    }


}