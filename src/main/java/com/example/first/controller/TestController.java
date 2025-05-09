package com.example.first.controller;

import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.example.first.mapper.OrderMapper;
import com.example.first.mapper.UserMapper;
import com.example.first.model.ResultJson;
import com.example.first.service.UserService;
import com.example.first.test.Test2;
import com.example.first.test.Test3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
public class TestController<T> {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Resource(name = "Test3")
    Test2 test3;

    @Autowired
    UserService userService;


    ExecutorService executor = Executors.newFixedThreadPool(12);

    @PostMapping("/pressure")
    public ResultJson<Object> pressure(@RequestBody Order order) {

        Long startTime = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(1000001);
        while (count.get() < 1100001) {
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

    @GetMapping("/test2")
    public ResultJson<Object> test2(String id) {
        Test2<String> test311 = new Test3();
        String verify = (String) test3.verify(id);
        String verify1 = test311.verify(id);


        List<String> strings = Arrays.asList("1");
        return ResultJson.toSuccess(verify);


    }

    @GetMapping("/queryTest")
    public ResultJson<Object> test(String userId) {

        for (int i = 0; i < 1100001; i++) {
            long startTime = System.currentTimeMillis();

            Order order = orderMapper.queryByUserId(userId);
            long time = System.currentTimeMillis() - startTime;
            log.info("查询耗费时间:{}", time);
        }

        return ResultJson.toSuccess();


    }

    @GetMapping("/queryTest1")
    public ResultJson<Object> test1(String userId) {

        for (int i = 0; i < 100000; i++) {
            long startTime = System.currentTimeMillis();

            int a = orderMapper.queryExist(userId);
            long time = System.currentTimeMillis() - startTime;
            log.info("耗费时间:{}", time);
        }

        return ResultJson.toSuccess();


    }

    @GetMapping("/updateAgeTest")
    public ResultJson<Object> test3(String id, Integer age,Integer extend) {

        log.info("id:{},age:{}", id, age);
        for (int i = 0; i < 10000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    User user = new User();
                    user.setId(id);
                    user.setAge(age);
                    userService.updateAge(user);
                }
            });

//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    User user = new User();
//                    user.setId(id);
//                    user.setExtend(extend);
//                    userService.updatExtend(user);
//                }
//            });

        }
        return ResultJson.toSuccess();


    }


}
