package com.example.first.demo;

/**
 * @author hujiahan
 * @date 2020/1/31 14:33
 */
public class TestObj {


    public static void main(String[] args) {
        Object o = new Object(){
          public boolean equals1(Object obj){
              return true;
          }
        };
        System.out.println(o.equals(""));
    }
}
