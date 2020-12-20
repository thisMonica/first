package com.example.first.mapper;

import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 14:24
 */
@Mapper
@Repository
public interface OrderMapper {

    List<Order> queryAll();

    boolean insert(Order order);

    Order queryByUserId(String userId);

    Integer queryExist(String userId);
}
