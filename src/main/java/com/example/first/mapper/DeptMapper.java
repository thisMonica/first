package com.example.first.mapper;

import com.example.first.entity.Dept;
import com.example.first.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hu
 * @date 2020/5/2 0:56
 */
@Mapper
@Repository
public interface DeptMapper {


    List<Dept> queryAll();

    boolean insert(Dept dept);

}
