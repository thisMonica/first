package com.example.first.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hu
 * @date 2021/1/14 11:13
 * @Description:
 */
public class Test12 {

    public static void main(String[] args) {
        String s = "特殊的一段话。{我是}，{傻币}，";
        List<Char> list = new ArrayList<Char>();
        do {
            s = getString(s, list);
        } while (s != null && s.indexOf("{") != -1);
        for (Char c : list) {
            System.out.println(c.str.substring(c.startIndex+1, c.endIndex));
        }
    }

    public static String getString(String str, List<Char> list) {
        char[] cs = str.toCharArray();
        boolean isStart = false;
        Char ch = new Char();
        ch.str = str;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '{') {
                if (!isStart) {
                    ch.startIndex = i;
                    isStart = true;
                }
                ch.layer++;
            } else if (c == '}' && ch.layer > 0) {
                ch.layer--;
                if (ch.layer == 0) {
                    ch.endIndex = i;
                    list.add(ch);
                    if (i != cs.length - 1) {
                        String last = str.substring(i + 1);
                        do {
                            last = getString(last, list);
                        } while (last != null && last.indexOf("{") != -1);
                    }
                    break;
                }
            }
        }
        if (ch.endIndex != 0) {
            return str.substring(ch.startIndex + 1, ch.endIndex);
        }
        return null;
    }

}

class Char {
    int startIndex;
    int endIndex;
    int layer;
    String str;
}
