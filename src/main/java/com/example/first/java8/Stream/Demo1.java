package com.example.first.java8.Stream;

/**
 * @author hu
 * @date 2020/5/14 0:13
 */

import com.example.first.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现
 * 现有5个用户，筛选：
 * 1、ID：必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户字母倒着排序
 * 5、只输出一个用户
 */
public class Demo1 {

    public static void main(String[] args) {
        User user1 = new User("1", "one", "132", "深圳", "25");
        User user2 = new User("2", "two", "138", "深圳", "26");
        User user3 = new User("3", "three", "136", "深圳", "21");
        User user4 = new User("4", "Four", "157", "深圳", "24");
        User user5 = new User("5", "five", "186", "深圳", "23");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
        list.stream()
                .filter((u) -> Integer.parseInt(u.getId()) % 2 == 0 && Integer.parseInt(u.getAge()) > 23)
                .map((u) -> u.getName().toUpperCase())
                .sorted((u1, u2) -> {return u2.compareTo(u1);})
                .limit(1).forEach(System.out::println);

    }


}
