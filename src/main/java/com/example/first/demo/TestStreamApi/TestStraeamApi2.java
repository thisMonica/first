package com.example.first.demo.TestStreamApi;

/**
 * @author hu
 * @date 2020/3/20 11:20
 */

import com.example.first.entity.Teacher;
import com.example.first.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
//@formatter:off
/**
 *  一、Stream的三个步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 *
 */
//@formatter:on
public class TestStraeamApi2 {

    //@formatter:off
    /**
     * 中间操作
     * 筛选和切片
     * filter——接受Lambda，从流中排除某些元素
     * limit——截断流，使其元素不能超过给定数量
     * skip(n)——跳过元素，返回一个扔掉了了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
     * distinct——筛选，通过流所生成元素的hashCode()和equals()去除重复元素.例如实体里可重写这两个方法
     */
    //@formatter:on

    List<Teacher> teachers = Arrays.asList(
            new Teacher("1", "黄", 20, 5500d),
            new Teacher("2", "张", 21, 5800d),
            new Teacher("3", "李", 23, 6000d),
            new Teacher("4", "赵", 25, 6500d)
    );


    //内部迭代：迭代操作由Stream API完成
    public void test() {
        Stream<Teacher> teacherStream = teachers.stream().filter((e) -> {
            System.out.println("中间操作");
            return e.getAge() > 22;
        });
        //中间操作：不会执行任何操作
        //终止操作：一次性执行全部内容，即"惰性求值"
        teacherStream.forEach(System.out::println);

    }

    //外部迭代：
    public void test1() {
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void test2() {
        teachers.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getSalary() > 5500;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    public void test3() {
        teachers.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getSalary() > 5500;
                })
                .skip(2)
                .forEach(System.out::println);
    }

    public void test4() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestStraeamApi2 testStraeamApi2 = new TestStraeamApi2();
        testStraeamApi2.test4();
    }
}
