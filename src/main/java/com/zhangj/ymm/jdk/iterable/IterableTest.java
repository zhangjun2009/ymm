package com.zhangj.ymm.jdk.iterable;

/**
 * @author zhangj
 * @date 2019/5/6
 */
public class IterableTest {
    public static void main(String[] args) {
        Students students = new Students(10);
        students.forEach(System.out::println);
    }
}
