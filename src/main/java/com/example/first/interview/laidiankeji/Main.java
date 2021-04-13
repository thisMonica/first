package com.example.first.interview.laidiankeji;


/**
 * @author hu
 * @date 2021/4/14 0:28
 * @desc:
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Test1.x);

        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        t2.setValue(3);
        t2.setValue(4);
        System.out.println(t1.getVale());
        System.out.println(t2.getVale());
    }

}
