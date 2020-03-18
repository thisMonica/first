package com.example.first.controller;

import com.example.first.entity.User;
import com.example.first.mapper.UserMapper;
import com.example.first.model.ResultJson;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 14:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
    public ResultJson<Object> save(User user) {

        boolean result = userService.save(user);

        return ResultJson.toSuccess(result);
    }


}
