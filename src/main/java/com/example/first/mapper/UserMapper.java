package com.example.first.mapper;

import com.example.first.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hu
 * @date 2020/3/18 14:24
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> queryAll();

    boolean insert(User user);

}
