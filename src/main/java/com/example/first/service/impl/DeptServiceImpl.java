package com.example.first.service.impl;

import com.example.first.entity.Dept;
import com.example.first.entity.User;
import com.example.first.mapper.DeptMapper;
import com.example.first.mapper.UserMapper;
import com.example.first.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hu
 * @date 2020/5/2 1:01
 */
@Service
@Slf4j
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }

    @Override
    public boolean save(Dept dept) {

        return deptMapper.insert(dept);
    }
}
