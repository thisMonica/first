package com.example.first.java8.Stream;

/**
 * @author hu
 * @date 2020/5/14 0:13
 */

import com.alibaba.fastjson.JSONObject;
import com.example.first.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
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

    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        User user1 = new User("1", "one", "132", "深圳", 25,1);
        User user2 = new User("2", "one", "138", "深圳", 26,1);
        User user3 = new User("3", "three", "136", "深圳", 21,1);
        User user4 = new User("4", "Four", "157", "深圳", 24,1);
        User user5 = new User("5", "five", "186", "深圳", 23,1);
        User user6 = new User("6", "five", "186", "深圳", 23,1);
        User user7 = new User("7", "five", "186", "深圳", 23,1);
        User user8 = new User("8", "five", "186", "深圳", 23,1);
        User user9 = new User("9", "five", "186", "深圳", 23,1);
        User user10 = new User("10", "five", "186", "深圳", 23,1);
        User user11 = new User("11", "five", "186", "深圳", 23,1);
        User user12 = new User("12", "five", "186", "深圳", 23,1);


        List<User> list = Arrays.asList(user1, user2, user3, user4, user5,user6,user7,user8,user9,user10);
//        list.stream()
//                .filter((u) -> Integer.parseInt(u.getId()) % 2 == 0 && Integer.parseInt(u.getAge()) > 23)
//                .map((u) -> u.getName().toUpperCase())
//                .sorted((u1, u2) -> {
//                    return u2.compareTo(u1);
//                })
//                .limit(1).forEach(System.out::println);
//
//        List<User> collect = list.stream().filter(l -> Integer.parseInt(l.getId()) > 3).collect(toList());
//        System.out.println(collect);
//        User user = list.stream().sorted(Comparator.comparing(User::getId).reversed()).findFirst().orElse(null);
//        System.out.println(user);


//        Map<String, String> levelMap = list.stream().
//                collect(Collectors.toMap(User::getId, User::getName));
//        String s = levelMap.get(null);
//        System.out.println(s);

//        List<User> studentDistinct2List = list.stream().filter(StreamUtil.distinctByKey(t->t.getName()))
//                .collect(Collectors.toList());

//        List<User> list1 = list.stream()
//                .collect(Collectors.collectingAndThen
//                        (Collectors.toCollection(() ->
//                                        new TreeSet<>(Comparator.comparing(t -> t.getName()))),
//                                ArrayList::new
//                        )
//                );
//        System.out.println(JSONObject.toJSONString(list1));
        for (User user : list) {
            executor.execute(()->{
                log.info("线程----{},用户id:{}",Thread.currentThread().getName(),user.getId());
            });
        }
    }


}
