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
//        user.setId(UUID.randomUUID().toString());
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
}
