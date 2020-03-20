package com.example.first.demo.TestLambda;

@FunctionalInterface
public interface MySort<T> {
    public boolean sort(T t);
}
