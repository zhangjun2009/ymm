package com.zhangj.ymm.leetcode.data_structure;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/5/6
 * 顺序队列
 */
public class MySequenceQueue {
    public static void main(String[] args) {
        MySequenceQueue queue = new MySequenceQueue(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
        System.out.println("====================================");
        System.out.println(queue.remove());
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
    }

    private int rear;
    private int front;
    private final Integer[] value;

    public MySequenceQueue(int size) {
        this.value = new Integer[size];
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return rear == value.length;
    }

    public boolean add(Integer e) {
        if (isFull()) {
            return false;
        } else {
            value[rear++] = e;
            return true;
        }
    }

    public Integer remove() {
        Integer temp;
        if (isEmpty()) {
            return null;
        } else {
            temp = value[front];
            value[front] = null;
            front++;
            return temp;
        }
    }
}
