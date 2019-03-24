package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/24
 */
public class BootClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
