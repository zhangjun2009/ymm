package com.zhangj.ymm.data_struct;

import java.lang.reflect.Array;

/**
 * @author zhangj
 * @date 2019/6/9
 * 数组实现的栈
 */
public class ArrayStack<T> {
    private final static int DEFAULT_SIZE = 12;
    private T[] array;
    private int count;

    public ArrayStack(Class<T> type) {
        this(DEFAULT_SIZE, type);
    }

    public ArrayStack(int size, Class<T> type) {
        array = (T[]) Array.newInstance(type, size);
        count = 0;
    }

    /**
     * 将t值添加到栈顶
     *
     * @param t
     */
    public void push(T t) {
        array[count++] = t;
    }

    /**
     * 返回栈顶的值
     *
     * @return
     */
    public T peek() {
        return array[count - 1];
    }

    /**
     * 删除并返回栈顶的值
     *
     * @return
     */
    public T pop() {
        T t = array[count - 1];
        count--;
        return t;
    }

    /**
     * 返回栈的大小
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回“栈”是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
