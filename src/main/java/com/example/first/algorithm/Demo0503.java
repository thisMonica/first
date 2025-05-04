package com.example.first.algorithm;

import java.util.*;

public class Demo0503 {


    public static void main(String[] args) {
           int a = fib(20);
        System.out.println(a);
    }

    public static  int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}


