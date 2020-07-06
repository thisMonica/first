package com.example.first.test;

import com.example.first.entity.Dept;
import com.example.first.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hu
 * @date 2020/5/20 23:59
 */
public class Test {


    public static void main(String[] args) {
//        System.out.println(fuc(1));
        String a ="1";
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;

        String b ="1";
        User user1 = new User();
        User user2 = new User();
        user1.setName("1");
        user2.setName("2");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Dept dept = new Dept();
        dept.setUsers(users);
        for (User user :users){
            user.setName("123");
        }
        System.out.println(users);



    }




}