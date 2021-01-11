package com.example.first.service;

import com.example.first.entity.Dept;
import com.example.first.entity.User;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 15:14
 */
public interface UserService {

    List<User> queryAll();

    boolean save(User user);

    //入职
    boolean Onboarding(User user, Dept dept);

    void test();

    boolean updateAge(User user);

    boolean updatExtend(User user);

}
