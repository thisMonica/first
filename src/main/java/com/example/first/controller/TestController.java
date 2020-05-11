package com.example.first.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.example.first.mapper.OrderMapper;
import com.example.first.model.ResultJson;
import com.example.first.utils.PropertiesUtils;
import com.example.first.utils.RsaAndAes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author hu
 * @date 2020/4/19 1:57
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    OrderMapper orderMapper;


    @PostMapping("/pressure")
    public ResultJson<Object> pressure(@RequestBody Order order) {


        Long startTime = System.currentTimeMillis();
        int count = 0;
        while (count < 190000) {
            order.setOrderId(UUID.randomUUID().toString().replace("-", ""));
            order.setCrateDate(new Date());
            boolean result = orderMapper.insert(order);
            count++;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间:"+(endTime - startTime));

        return ResultJson.toSuccess(true);


    }


    @GetMapping("/query")
    public ResultJson<Object> query() {
        List<Order> list = orderMapper.queryAll();

        return ResultJson.toSuccess(list);


    }


}
