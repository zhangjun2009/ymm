package com.zhangj.ymm.data_struct;

/**
 * @author zhangj
 * @date 2019/6/9
 * 数组实现的队列
 */
public class ArrayQueue {
    private final static int DEFAULT_SIZE = 10;
    private int[] array;
    private int count;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int size) {
        array = new int[size];
        count = 0;
    }

    /**
     * 将val添加到队列的末尾
     *
     * @param val
     */
    public void add(int val) {
        array[count++] = val;
    }

    /**
     * 返回“队列开头元素”
     *
     * @return
     */
    public int front() {
        return array[0];
    }

    /**
     * 删除并返回队首元素
     *
     * @return
     */
    public int del() {
        int val = array[0];
        count--;
        for (int i = 1; i <= count; i++) {
            array[i - 1] = array[i];
        }
        return val;
    }

    /**
     * 返回队列大小
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
