package com.zhangj.ymm.data_struct.array;

/**
 * @author zhangj
 * @date 2019/6/19
 */
public class GenericArray<T> {
    /**
     * 数组的默认长度
     */
    private final static int DEFAULT_SIZE = 10;
    /**
     * 存储数据的data
     */
    public T[] data;
    /**
     * 数组的实际长度
     */
    private int size;

    public GenericArray() {
        this(DEFAULT_SIZE);
    }

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前数组元素个数
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 设置index位置处的数据为e
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /**
     * 获取index处的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标,没找到为-1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
}
