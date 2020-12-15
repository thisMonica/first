package com.example.first.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hu
 * @date 2020/10/27 9:58
 * @Description:
 */
@Slf4j
public class Test1 {


    public static void main(String[] args) {
        try {
            int a = 1/0;
        } catch (Exception e) {
            log.error("计算报错{},{}",e,1);
        }

    }
}
