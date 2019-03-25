package com.zhangj.ymm.thread.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangj
 * @date 2019/3/25
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
        Class<?> clazz = myClassLoader.loadClass("com.zhangj.ymm.thread.demo3.MyObjectTest");
        System.out.println(clazz.getClassLoader());
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("say", new Class<?>[]{});
        Object result = method.invoke(obj, new Object[]{});
        System.out.println(result);
    }
}
