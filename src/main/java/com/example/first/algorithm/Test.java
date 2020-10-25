package com.example.first.algorithm;

import com.example.first.entity.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hu
 * @date 2020/7/21 22:13
 */
public class Test {


    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("1", "张三", 20, 1200d, 1);
        Teacher teacher2 = new Teacher("2", "张三", 21, 1000d, 2);
        List<Teacher> list = Arrays.asList(teacher1, teacher2);
        List<Teacher> list11 = new ArrayList<>();
        List<Teacher> list1 = list11.stream()
                .sorted(Comparator.comparing(Teacher::getSort))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list1);

    }
}
