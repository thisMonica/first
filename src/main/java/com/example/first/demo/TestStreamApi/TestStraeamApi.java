package com.example.first.demo.TestStreamApi;

/**
 * @author hu
 * @date 2020/3/20 11:20
 */

import com.example.first.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @formatter:on 一、Stream的三个步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 * @formatter:off
 */
public class TestStraeamApi {

    public void test() {
        //1、可以通过Collection系列集合提供的Stream或者parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2、通过Arrays中静态方法stream()获取数组刘
        User user[] = new User[10];
        Stream<User> stream1 = Arrays.stream(user);

        //3、通过Stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //4、创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        stream3.forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

    }

}
