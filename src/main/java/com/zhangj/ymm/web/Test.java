package com.zhangj.ymm.web;

import java.util.ArrayDeque;

/**
 * @author zhangj
 * @date 2019/7/18
 */
public class Test {
    private static final ThreadLocal<Boolean> IS_NOT_FIND = new ThreadLocal<>();

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    }

    private static void method1() {
        for (int i = 0; i < 3; i++) {
            if (IS_NOT_FIND.get()) {
                System.out.println("bmain:" + i);
                method2();
            }
        }
    }

    private static void method2() {
        for (int i = 0; i < 3; i++) {
            if (IS_NOT_FIND.get()) {
                System.out.println("cmain:" + i);
                IS_NOT_FIND.set(false);
            }
        }
    }
}
