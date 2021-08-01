package com.example.first;

import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.example.first.service.CommonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class FirstApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    CommonService commonService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    /**
     * redis五大类型：
     * String(字符串)、List(列表)、Set(集合)、Hash(散列)、Zset(有序集合)
     * redisTemplate.opsForValue();String
     * redisTemplate.opsForList();List
     * redisTemplate.opsForHash();Hash
     * redisTemplate.opsForZSet();Zset
     * redisTemplate.opsForSet();Set
     */

    @Test
    void redisTest() {
        redisTemplate.opsForValue().set("test", 213);
        String test = redisTemplate.opsForValue().get("test").toString();
        System.out.println(test);
        redisTemplate.opsForList();
        redisTemplate.opsForHash();
        redisTemplate.opsForZSet();
        redisTemplate.opsForSet();
        stringRedisTemplate.opsForValue().set("msg","hello");
    }

    @Test
    void redisTest1() {
        redisTemplate.opsForValue().set("test", 213);
        String test = redisTemplate.opsForValue().get("test").toString();
        System.out.println(test);
        redisTemplate.opsForList();
        redisTemplate.opsForHash();
        redisTemplate.opsForZSet();
        redisTemplate.opsForSet();
        stringRedisTemplate.opsForValue().set("msg","hello");
    }


    @Test
    public void test1(){
        User user = new User();
        user.setId("100");
        user.setAge(100);
        user.setName("张三");
        user.setPhone("13924198448");

        Order order = new Order();
        order.setOrderId("10000000000000");
        order.setRemarks("aadasd");
        boolean res = commonService.tranTest(user, order);
        System.out.println(res);
    }

}
