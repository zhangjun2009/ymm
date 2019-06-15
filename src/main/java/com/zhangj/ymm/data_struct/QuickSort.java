package com.zhangj.ymm.data_struct;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/6/15
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {10, 5, 4, 9, 6, 3};
        sort(a, 0, 5);
        Arrays.stream(a).forEach(System.out::println);
    }

    /**
     * @param a 待排序数组
     * @param l 数组的左边界,例如,从起始位置开始排序,则l=0
     * @param r 数组的右边界,例如,排序到数组末尾,则 r=a.length-1
     */
    public static void sort(int a[], int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) {
                    //从右向左找第一个小于X的数
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < x) {
                    //从左向右找到第一个大于X的数
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            sort(a, l, i - 1);
            sort(a, l + 1, r);
        }
    }
}
