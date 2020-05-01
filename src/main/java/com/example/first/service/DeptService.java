package com.example.first.service;

import com.example.first.entity.Dept;
import com.example.first.entity.User;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 15:14
 */
public interface DeptService {

    List<Dept> queryAll();

    boolean save(Dept dept);

}
