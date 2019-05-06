package com.zhangj.ymm.leetcode.data_structure;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/5/6
 * 循环队列--空闲单元法
 */
public class MyCycleQueue1 {
    public static void main(String[] args) {
        MyCycleQueue1 queue = new MyCycleQueue1(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
        System.out.println("==============================================");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
    }

    private int rear;
    private int front;
    private final Integer[] value;

    public MyCycleQueue1(int size) {
        this.value = new Integer[size];
    }

    public int size() {
        return (value.length + rear - front) % value.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return front == (rear + 1) % value.length;
    }

    public boolean add(Integer e) {
        if (isFull()) {
            return false;
        } else {
            value[rear] = e;
            if (rear == value.length - 1) {
                rear = 0;
            } else {
                rear++;
            }
            return true;
        }
    }

    public Integer remove() {
        Integer temp = null;
        if (isEmpty()) {
            return temp;
        } else {
            temp = value[front];
            value[front] = null;
            if (front == value.length - 1) {
                front = 0;
            } else {
                front++;
            }
            return temp;
        }
    }
}
