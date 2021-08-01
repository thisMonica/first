package com.example.first.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hu
 * @date 2021/1/14 11:13
 * @Description:
 */
public class Test13 {

    public static void main(String[] args) {

        String role = "${inputCount}*0.04*383+${saleCount}*15";
        Pattern p = Pattern.compile("\\{.*?\\}");// 查找规则公式中大括号以内的字符
        Matcher m = p.matcher(role);
        String param = null;
        while (m.find()) {// 遍历找到的所有大括号
            param = m.group().replaceAll("\\{\\}", "");// 去掉括号

        }
        System.out.println(param);
    }
}
