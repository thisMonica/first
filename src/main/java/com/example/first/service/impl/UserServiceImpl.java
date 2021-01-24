package com.example.first.service.impl;

import com.example.first.entity.Dept;
import com.example.first.entity.User;

import java.util.*;

import com.example.first.mapper.DeptMapper;
import com.example.first.mapper.UserMapper;
import com.example.first.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 15:15
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    static String a = "a";

    static List<User> users = new ArrayList<>();

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public boolean save(User user) {
        user.setId(UUID.randomUUID().toString());
        return userMapper.insert(user);
    }

    @Override
    public boolean Onboarding(User user, Dept dept) {

        boolean res1 = deptMapper.insert(dept);
        log.info("res1:{}", res1);
        boolean res2 = userMapper.insert(user);
        log.info("res2:{}", res2);
        return res1 && res2;
    }

    @Override
    public void test() {
        User user1 = new User();
        user1.setId("1");
        User user2 = new User();
        user2.setId("2");
        users.add(user1);
        users.add(user2);
        System.out.println(users);
        int i = 0;
        while (true) {
            System.out.println(i++);
            users.add(user1);
        }

    }

    @Override
    public boolean updateAge(User user) {
//        User u = userMapper.queryById(user.getId());
//        Integer age = u.getAge() + user.getAge();
//        log.info("age:{}", age);
//        user.setAge(age);
        boolean update = userMapper.updateAge(user);

        return update;
    }

    @Override
    public boolean updatExtend(User user) {

        boolean update = userMapper.updatExtend(user);

        return update;
    }

    @Override
    public boolean sub(User user) {
        boolean result = userMapper.sub(user);

        return result;
    }

    @Override
    public boolean plus(User user) {
        boolean result = userMapper.plus(user);

        return result;
    }
//
    @Override
    public boolean transfer(User fromUser, User toUser) {

        boolean result1 = userMapper.sub(fromUser);

        boolean result2 = userMapper.plus(toUser);


        return result1 && result2;
    }
}
