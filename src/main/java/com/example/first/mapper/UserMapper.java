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

    User queryById(String id);

    boolean insert(User user);

    boolean updateAge(User user);

    boolean updatExtend(User user);

    boolean sub(User user);

    boolean plus(User user);

    boolean updateById(User user);

}
