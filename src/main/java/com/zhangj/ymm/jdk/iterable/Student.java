package com.zhangj.ymm.jdk.iterable;

import lombok.Data;

/**
 * @author zhangj
 * @date 2019/5/6
 */
@Data
public class Student {
    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    private int sid;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
