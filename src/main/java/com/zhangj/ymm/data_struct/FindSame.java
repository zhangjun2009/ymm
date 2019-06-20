package com.zhangj.ymm.data_struct;

/**
 * @author zhangj
 * @date 2019/6/17
 */
public class FindSame {
    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 2, 5, 2, 3, 6}));
    }

    /**
     * @param array 待查找的数组
     * @return
     */
    public static int find(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        return -1;
    }
}
