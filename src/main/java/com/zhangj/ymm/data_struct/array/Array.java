package com.zhangj.ymm.data_struct.array;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/6/19
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    /**
     * data保存数据
     */
    public int[] data;
    /**
     * 数组的长度
     */
    private int n;
    /**
     * 实际数组中元素个数
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据索引,找到数据中的元素并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return -1;
        }
        return data[index];
    }

    /**
     * 在数组index位置处插入value
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //数组已满
        if (n == count) {
            System.out.println("数组已满没有位置可以插入");
            return false;
        }
        //插入位置index不合理
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 删除index位置处的元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = index + 1; i <= count; ++i) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    /**
     * 打印数组
     */
    public void printAll() {
        Arrays.stream(data).forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.delete(1);
        array.printAll();
    }
}
