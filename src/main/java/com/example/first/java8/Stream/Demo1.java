package com.example.first.java8.Stream;

/**
 * @author hu
 * @date 2020/5/14 0:13
 */

import com.example.first.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现
 * 现有5个用户，筛选：
 * 1、ID：必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户字母倒着排序
 * 5、只输出一个用户
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) {
        User user1 = new User("1", "one", "132", "深圳", "25");
        User user2 = new User("2", "two", "138", "深圳", "26");
        User user3 = new User("3", "three", "136", "深圳", "21");
        User user4 = new User("4", "Four", "157", "深圳", "24");
        User user5 = new User("5", "five", "186", "深圳", "23");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
//        list.stream()
//                .filter((u) -> Integer.parseInt(u.getId()) % 2 == 0 && Integer.parseInt(u.getAge()) > 23)
//                .map((u) -> u.getName().toUpperCase())
//                .sorted((u1, u2) -> {
//                    return u2.compareTo(u1);
//                })
//                .limit(1).forEach(System.out::printl n);
//
//        List<User> collect = list.stream().filter(l -> Integer.parseInt(l.getId()) > 3).collect(toList());
//        System.out.println(collect);
//        User user = list.stream().sorted(Comparator.comparing(User::getId).reversed()).findFirst().orElse(null);
//        System.out.println(user);

//        int a = 1;
//        int b = 0;
//        try {
//            int c = a / b;
//        } catch (Exception e) {
//            log.info(e.getMessage());
//            int c = a / b;
//            System.out.println(c);
//        } finally {
//            System.out.println("后续");
//        }

        String key = "a";
        switch (key) {
            case "a":
                System.out.println(1);
                System.out.println(1);
                System.out.println(1);
                break;
            case "b":
                System.out.println(2);
                System.out.println(2);
                System.out.println(2);
                break;
            case "c":
                System.out.println(3);
                System.out.println(3);
                System.out.println(3);
                break;

        }



    }


}
