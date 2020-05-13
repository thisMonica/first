package com.example.first.java8.TestLambda;

@FunctionalInterface
public interface MySort<T> {
    public boolean sort(T t);
}
