package com.example.first.service;

import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.example.first.mapper.OrderMapper;
import com.example.first.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

/**
 * @author hu
 * @date 2021/6/26 23:36
 * @desc:
 */
@Service
public class CommonService {

    OrderMapper orderMapper;

    UserMapper userMapper;

    @Transactional(propagation = REQUIRES_NEW)
    public boolean tranTest(User user, Order order) {
        boolean res2 = false;
        boolean res1 = false;
        orderMapper.updateById(order);
        int a = 1 /0 ;
        userMapper.updateById(user);
        return res2 && res1;
    }

}
