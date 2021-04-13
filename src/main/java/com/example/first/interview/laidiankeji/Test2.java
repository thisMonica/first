package com.example.first.interview.laidiankeji;

/**
 * @author hu
 * @date 2021/4/13 0:15
 * @desc:
 */
public class Test2 {

    static boolean foo(char c) {

        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && i < 2; foo('C')) {
            i++;
            foo('D');
        }

    }
}
