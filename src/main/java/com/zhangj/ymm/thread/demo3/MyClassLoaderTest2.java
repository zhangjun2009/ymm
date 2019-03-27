package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/26
 */
public class MyClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader1 = new MyClassLoader("MyClassLoader-1");
        MyClassLoader myClassLoader2 = new MyClassLoader("MyClassLoader-2", myClassLoader1);
        myClassLoader2.setDir("D:\\classloader2");
        Class<?> aClass = myClassLoader2.loadClass("com.zhangj.ymm.thread.demo3.MyObjectTest");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
    }
}
