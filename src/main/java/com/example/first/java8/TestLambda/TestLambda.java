package com.example.first.java8.TestLambda;

import com.example.first.entity.User;

import java.util.*;

public class TestLambda {

    public void test1() {
        //原来的匿名内部类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //Lambda表达式
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    static List<User> users = Arrays.asList(
            new User("1", "张三", "130", "深圳", "18"),
            new User("2", "张三", "130", "深圳", "19"),
            new User("3", "张三", "130", "深圳", "20"),
            new User("4", "张三", "130", "深圳", "21")
    );


    //需求：获取id大于2的用户
    public List<User> filterUser1(List<User> users) {
        List<User> list = new ArrayList<>();
        for (User user : users) {
            if (user.getId().compareTo("2") > 0) {
                list.add(user);
            }
        }
        System.out.println(list.toString());
        return list;
    }

    //需求:获取年龄大于18的用户
    public List<User> filterUser2(List<User> users) {
        List<User> list = new ArrayList<>();
        for (User user : users) {
            if (user.getAge().compareTo("18") > 0) {
                list.add(user);
            }
        }
        System.out.println(list.toString());
        return list;
    }

    public List<User> filterUser(List<User> users, MySort<User> mySort) {
        List<User> list = new ArrayList<>();
        for (User user : users) {
            if (mySort.sort(user)) {
                list.add(user);
            }
        }
        System.out.println(list.toString());
        return list;
    }

    //优化方式一：策略设计模式
    public void test3() {
        List<User> list1 = filterUser(users, new UserSortByAge());
        System.out.println(list1.toString());
        System.out.println("------------");
        List<User> list2 = filterUser(list1, new UserSortById());
        System.out.println(list2.toString());
    }

    //优化方式二：匿名内部类
    public void test4() {
        List<User> list = filterUser(users, new MySort<User>() {
            @Override
            public boolean sort(User user) {
                return user.getAge().compareTo("18") > 0;
            }
        });
        System.out.println(list);
    }

    //优化方式三：Lambda表达式
    public void test5() {
        List<User> list = filterUser(users, e -> e.getAge().compareTo("18") > 0);
        list.forEach(System.out::println);
    }

    //优化方式四：Stream Api
    public void test6() {
        users.stream().filter((e) -> e.getAge().compareTo("18") > 0).forEach(System.out::println);
    }

    public static void main(String[] args) {

        TestLambda testLambda = new TestLambda();
//        testLambda.filterUser2(users);
        testLambda.test6();
    }


}
