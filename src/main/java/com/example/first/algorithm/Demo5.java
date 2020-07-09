package com.example.first.algorithm;

/**
 * @author hu
 * @date 2020/7/9 16:26
 */
public class Demo5 {

    public static void main(String[] args) {

        int[] arr ={1,0,2,4,0,-1,3,6};
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            //当前遍历的数如果比 max 大，就将该数赋值给 max
            if (arr[i] > max) {
                max = arr[i];
            }

            //当前遍历的数如果比 min 小，就将该数赋值给 min
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("数组的最小值是：" + min);
        System.out.println("数组的最大值是：" + max);
    }

}
