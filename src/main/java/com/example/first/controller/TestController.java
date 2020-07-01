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

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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

    ExecutorService executor = Executors.newFixedThreadPool(12);

    @PostMapping("/pressure")
    public ResultJson<Object> pressure(@RequestBody Order order) {

        Long startTime = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(0);
        while (count.get() < 1000000) {
            order.setOrderId(count.get() + "");
            order.setUserId(UUID.randomUUID().toString().replace("-", ""));
            order.setCommodityId(UUID.randomUUID().toString().replace("-", ""));
            order.setCrateDate(new Date());
            order.setAmount(count.get());
            order.setTotalPrice(new BigDecimal(order.getAmount()));
            String remarks = "";
            for (int i = 0; i < 10; i++) {
                char c = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
                remarks += c;
            }
            order.setRemarks(remarks);
            if (count.get() != 0) {
                order.setFee(new BigDecimal(count.get() % 2));
            }
            if (count.get() > 500000) {
                order.setPayment("1");
                order.setStatus("1");
                order.setDelFlag("0");
            } else {
                order.setUpdateDate(new Date());
                order.setPayment("2");
                order.setStatus("0");
                order.setDelFlag("1");
            }
            orderMapper.insert(order);
            count.incrementAndGet();


        }
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间:" + (endTime - startTime));

        return ResultJson.toSuccess(true);


    }


    @GetMapping("/query")
    public ResultJson<Object> query() {
        List<Order> list = orderMapper.queryAll();

        return ResultJson.toSuccess(list);


    }


    public static void main(String[] args) {
        String a = "";
        for (int i = 0; i < 10; i++) {
            char c = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
            a += c;
        }
        System.out.println(a);
    }

}
