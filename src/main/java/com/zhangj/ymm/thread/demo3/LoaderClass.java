package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/24
 */
public class LoaderClass {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
    }
}

class MyObject {

}
