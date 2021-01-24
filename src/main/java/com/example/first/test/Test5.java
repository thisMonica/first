package com.example.first.test;

/**
 * @author hu
 * @date 2020/12/15 9:47
 * @Description:
 */
import org.springframework.stereotype.Service;

/**
 * @author hu
 * @date 2020/12/15 0:20
 * @desc:
 */
@Service
public interface Test5<T> {


    <T> T verify(T a);

}