package com.zhangj.creational.builder;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class Test {
    public static void main(String[] args) {
        Student student = new StudentActualBuilder().buildName("zhangj").buildAge(12).buildSex("man").make();
        System.out.println(student.toString());
    }
}
