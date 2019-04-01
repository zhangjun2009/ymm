package com.zhangj.ymm.thread.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangj
 * @date 2019/3/27
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        //create
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());
        i = new AtomicInteger(10);
        System.out.println(i.get());
        //set
        i.set(12);
        System.out.println(i.get());
        i.lazySet(55);
        System.out.println(i.get());
        //get and add
        AtomicInteger getAndAdd = new AtomicInteger(10);
        int andAdd = getAndAdd.getAndAdd(1);
        System.out.println(andAdd);
        System.out.println(getAndAdd.get());
        //get and set
        AtomicInteger getAndSet = new AtomicInteger(10);
        int andSet = getAndSet.getAndSet(10);
        System.out.println(andSet);
        System.out.println(getAndSet.get());
        //compare and set
        AtomicInteger compareAndSet = new AtomicInteger(10);
        compareAndSet.compareAndSet(10, 12);
        System.out.println(compareAndSet.get());
    }
}
