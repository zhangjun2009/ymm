package com.zhangj.creational.builder;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class StudentActualBuilder extends StudentBuilder {
    private Student student = new Student();

    @Override
    public StudentBuilder buildName(String name) {
        this.student.setName(name);
        return this;
    }

    @Override
    public StudentBuilder buildSex(String sex) {
        this.student.setSex(sex);
        return this;
    }

    @Override
    public StudentBuilder buildAge(int age) {
        this.student.setAge(age);
        return this;
    }

    @Override
    public Student make() {
        return student;
    }
}
