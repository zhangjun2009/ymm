package com.zhangj.ymm.thread.demo2.Immutable_object;

/**
 * @author zhangj
 * @date 2019/3/12
 * 不可变对象是线程安全的
 */
final public class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
