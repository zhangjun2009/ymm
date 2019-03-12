package com.zhangj.ymm.thread.demo2.Immutable_object;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}
