package com.example.first.service.impl;

import com.example.first.entity.User;
import java.util.*;
import com.example.first.mapper.UserMapper;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 15:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public boolean save(User user) {
        user.setId(UUID.randomUUID().toString());
        return userMapper.insert(user);
    }
}
