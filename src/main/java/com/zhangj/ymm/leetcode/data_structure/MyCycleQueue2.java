package com.zhangj.ymm.leetcode.data_structure;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/5/6
 * 循环队列--计数器法
 */
public class MyCycleQueue2 {
    private int rear;
    private int front;
    private int count;
    private final Integer[] value;

    public static void main(String[] args) {
        MyCycleQueue2 queue = new MyCycleQueue2(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
        System.out.println("=======================================");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.add(4));
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("isFull:" + queue.isFull());
        System.out.println("size:" + queue.size());
        Arrays.stream(queue.value).forEach(System.out::println);
    }

    public MyCycleQueue2(int size) {
        this.value = new Integer[size];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (front == rear) && count == 0;
    }

    public boolean isFull() {
        return (front == rear) && count > 0;
    }

    public boolean add(Integer e) {
        if (isFull()) {
            return false;
        } else {
            count++;
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
            count--;
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
