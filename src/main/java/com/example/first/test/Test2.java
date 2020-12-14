package com.example.first.test;

import org.springframework.stereotype.Service;

/**
 * @author hu
 * @date 2020/12/15 0:20
 * @desc:
 */
@Service
public interface Test2<T> {


    <T> T verify(T a);

}
