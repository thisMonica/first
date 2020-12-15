package com.example.first.algorithm;

import com.example.first.entity.Dept;
import com.example.first.entity.Teacher;
import com.example.first.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author hu
 * @date 2020/5/20 23:59
 */
public class Demo6 {


    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("1", "张三", 20, 1200d, 1);
        Teacher teacher2 = new Teacher("2", "张三", 21, 1000d, 2);
        Teacher teacher3 = new Teacher("3", "张三", 22, 1100d, 3);
        Teacher teacher4 = new Teacher("4", "张三", 23, 1000d, 4);
        Teacher teacher5 = new Teacher("1", "张三", 24, 1500d, 5);
        Teacher teacher6 = new Teacher("3", "张三", 25, 1000d, 6);
        Teacher teacher7 = new Teacher("5", "张三", 26, 1300d, 7);
        Teacher teacher8 = new Teacher("10", "张三", 27, 1300d, 8);
        Teacher teacher9 = new Teacher("7", "张三", 28, 1700d, 9);
        Teacher teacher10 = new Teacher("6", "张三", 29, 1800d, 10);
        Map<String, Teacher> map = new HashMap<>();
        List<Teacher> list = Arrays.asList(teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7, teacher8, teacher9, teacher10);
        //id相同时，取Salary较大的
        for (Teacher teacher : list) {
            if (map.get(teacher.getId()) == null) {
                map.put(teacher.getId(), teacher);
            } else {
                Teacher t1 = map.get(teacher.getId());
                if (teacher.getSalary() > t1.getSalary()) {
                    map.put(teacher.getId(), teacher);
                }
            }
        }

        System.out.println(map);
        List<Teacher> result = new ArrayList<Teacher>(map.values());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("排序后");
        List<Teacher> collect = result.stream()
                .sorted(Comparator.comparing(Teacher::getSalary).reversed())
//                .sorted(Comparator.comparing(Teacher::getSort))
                .collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }


        //最后排序
        List<Teacher> collect1 = collect.stream()
                .sorted(Comparator.comparing(Teacher::getSort))
                .limit(3)
                .collect(Collectors.toList());


        System.out.println("最后结果");
        for (int i = 0; i < collect1.size(); i++) {
            System.out.println(collect1.get(i));
        }


    }


}