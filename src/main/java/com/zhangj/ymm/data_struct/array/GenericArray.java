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

    /**
     * 在index位置插入元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndex(index);
        //如果当前数组长度等于数组初始大小,则进行扩容
        if (data.length == size) {
            resize(2 * size);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头插入元素e
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组尾部插入元素e
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除index位置处的元素,并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T removeData = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[index] = null;
        return removeData;
    }

    /**
     * 删除第一个元素
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除最后一个元素
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * 从数组中删除
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
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

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(5);
        array.add(0, 0);
        array.add(1, 1);
        array.add(2, 2);
        array.add(3, 3);
        System.out.println(array.toString());
        array.addFirst(12);
        array.addLast(22);
        System.out.println(array.toString());
        array.removeElement(11);
        System.out.println(array.toString());
    }
}
