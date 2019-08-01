package com.zhangj.creational.builder;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public abstract class StudentBuilder {
    public abstract StudentBuilder buildName(String name);

    public abstract StudentBuilder buildSex(String sex);

    public abstract StudentBuilder buildAge(int age);

    public abstract Student make();
}
