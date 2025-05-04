package com.example.first.controller;

import java.util.ArrayList;
import java.util.List;

public class Test {

//    public static void main(String[] args) {
//
//        int[] digits = {1, 2, 9};
//        int[] newDigits = new int[digits.length];
//        for (int i = 0; i < digits.length; i++) {
//            int d = digits[i];
//            newDigits[i] = d;
//        }
//        if (newDigits[newDigits.length - 1] != 9) {
//            newDigits[newDigits.length - 1] += 1;
//        } else {
//            int[] newDigits1 = new int[digits.length + 1];
//            for (int i = 0; i < newDigits1.length; i++) {
//                if (i == newDigits1.length - 2) {
//                    newDigits1[newDigits1.length -2] = 1;
//                    continue;
//                }
//                if (i == newDigits1.length - 1) {
//                    newDigits1[newDigits1.length -1] = 0;
//                    continue;
//                }
//                int d = digits[i];
//                newDigits1[i] = d;
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 9};
        int[] newDigits = new int[digits.length];
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + digits[i];
        }
        System.out.println(sum);

    }


}

