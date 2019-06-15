package com.zhangj.ymm.data_struct;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/6/15
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {10, 5, 20, 15, 3, 9};
        sort1(a, 6);
        Arrays.stream(a).forEach(System.out::println);
    }

    /**
     * @param a 待排序数组
     * @param n 数组的长度
     */
    public static void sort1(int[] a, int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }

    }
}
