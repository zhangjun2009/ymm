package com.zhangj.ymm.work;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer integerL : list) {
            System.out.println(integerL);
        }
    }
}
