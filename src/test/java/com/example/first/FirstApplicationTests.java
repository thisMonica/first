package com.example.first;

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

}
