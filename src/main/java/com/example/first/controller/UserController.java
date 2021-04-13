package com.example.first.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.first.entity.Dept;
import com.example.first.entity.User;
import com.example.first.mapper.UserMapper;
import com.example.first.model.ResultJson;
import com.example.first.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hu
 * @date 2020/3/18 14:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired()
    UserService userService;

    @Autowired
    StringRedisTemplate srt;

    @GetMapping("/queryAll")
    public ResultJson<Object> queryAll() {

        List<User> users = userService.queryAll();

        return ResultJson.toSuccess(users);
    }

    /*
     1.如果前端传入的是json数据那么后端使用 
     @RequestBody HashMap<String, String> map 
     进行接收，然后再通过map.get(“XXX”)获取对应的数据

     2.如果前端传入的是正常表单数据，那么后端使用 
     @RequestParam("XXX") String XXX或者 
     @RequestParam(value="XXX", required = false) String XXX接收参数
     */


    @PostMapping("/save")
    public ResultJson<Object> save(@RequestBody User user) {
//        int count = 0;
//        while (count < 100000) {
//            userService.save(user);
//            count++;
//        }

        boolean save = userService.save(user);
        return ResultJson.toSuccess(save);
    }

    @PostMapping("/Onboarding")
    public ResultJson<Object> Onboarding(@RequestBody String req) {
        JSONObject params = JSONObject.parseObject(req).getJSONObject("req");
        User user = new User();
        user.setId(params.getString("id"));
        user.setAge(params.getInteger("age"));
        user.setName(params.getString("name"));
        user.setPhone(params.getString("132"));
        user.setArea(params.getString("area"));
        Dept dept = Dept.builder()
                .deptId(params.getString("deptId"))
                .deptName(params.getString("deptName"))
                .deptNo(params.getString("deptNo"))
                .userId(params.getString("userId"))
                .build();
        boolean result = userService.Onboarding(user, dept);
        return ResultJson.toSuccess(result);
    }


    @GetMapping("/test")
    public ResultJson<Object> test() {
        userService.test();
        return ResultJson.toSuccess();
    }

    public static void main(String[] args) {
        new Thread().run();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000000; i++) {

                }
            }
        });
    }


    @GetMapping("/transfer")
    public void transfer() {

        User fromUser = new User();
//        fromUser.setId("1");
        fromUser.setExtend(100);
        fromUser.setPhone("132");
        fromUser.setName("战三");
        User toUser = new User();
//        toUser.setId("2");
        toUser.setExtend(100);
        toUser.setPhone("123");
        toUser.setName("李四");

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userService.transfer(fromUser,toUser);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    userService.transfer(toUser,fromUser);
                }
            }).start();
        }



    }


}
