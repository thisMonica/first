package com.example.first.test;

import com.example.first.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author hu
 * @date 2020/5/20 23:59
 */
public class Test {


    public static void main(String[] args) {

        User user1 = new User("1", "one", "132", "深圳", "25");
        User user2 = new User("2", "two", "138", "深圳", "26");
        User user3 = new User("3", "three", "136", "深圳", "21");
        User user4 = new User("4", "Four", "157", "深圳", "24");
        User user5 = new User("5", "five", "186", "深圳", "23");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
//        System.out.println(fuc(1));
        String a ="1";
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;

        int i = Collections.binarySearch(list, user1);
        System.out.println(i);


    }




}