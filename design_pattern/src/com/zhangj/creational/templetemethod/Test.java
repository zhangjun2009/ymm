package com.zhangj.creational.templetemethod;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class Test {
    public static void main(String[] args) {
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();

        ACourse feCourse = new FECourse();
        feCourse.makeCourse();
    }
}
