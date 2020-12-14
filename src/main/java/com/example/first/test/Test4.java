package com.example.first.test;

import io.netty.util.Recycler;

/**
 * @author hu
 * @date 2020/12/15 0:22
 * @desc:
 */
public class Test4 implements Test2{

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public Object verify(Object a) {
        return null;
    }
}
