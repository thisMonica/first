package com.example.first.algorithm;

/**
 * @author hu
 * @date 2020/7/10 0:01
 */
public class Demo4 {


    /**
     * 冒泡排序
     */
    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 8, 5, 6, 2, 9, 7};
        int[] sort = sort(arr);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }


    }
    public static int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            //循环次数  每完成一次  沉入底部一个数
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


 }