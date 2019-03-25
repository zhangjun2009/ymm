package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/25
 */
public class MyObjectTest {
    static {
        System.out.println("MyObjectTest will be init.");
    }

    public String say() {
        return "good bye!";
    }
}
