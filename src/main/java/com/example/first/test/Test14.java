package com.example.first.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hu
 * @date 2021/7/16 2:10
 * @desc:
 */
public class Test14 {

    public static void main(String args[]) {
        String str = "特{我是}大{帅哥}，{你}不服吗{？}，{}，1231：{}";
        ArrayList<String> word = new ArrayList<String>();
        int n = 0, m;
        int count = 0;
        String param = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                if (count == 0) {
                    param += "{";
                    n = i;
                }
                count++;
            }
            if (str.charAt(i) == '}') {
                param += "}";
                count--;
                if (count == 0) {
                    m = i;
                    word.add(str.substring(n + 1, m));
                }
            }
            if (str.charAt(i) != '{' && str.charAt(i) != '}' && !param.endsWith("{")) {
                param += str.charAt(i);
            }
        }
        for (String a : word) {
            System.out.println(a);
        }
        System.out.println(param);
    }

}
