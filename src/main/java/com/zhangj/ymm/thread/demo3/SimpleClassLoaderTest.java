package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/27
 */
public class SimpleClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader("simpleClassLoader");
        Class<?> aClass = simpleClassLoader.loadClass("com.zhangj.ymm.thread.demo3.SimpleObject");
        System.out.println(aClass.getClassLoader());
    }
}
