package com.zhangj.ymm.data_struct.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangj
 * @date 2019/6/22
 * 基于数组实现的LRU缓存
 */
public class LRUBasedArray<T> {
    /**
     * 数组默认初始容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * 数组容量
     */
    private int capacity;

    /**
     * 数组中元素个数
     */
    private int count;

    /**
     * 存储数组值
     */
    private T[] value;

    /**
     * 访问次数计数器
     */
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    /**
     * 访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值,则更新位置
     *
     * @param end
     */
    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存满了,踢出最后的元素,并缓存
     *
     * @param object
     */
    public void removeAndCache(T object) {
        T value = this.value[--count];
        holder.remove(value);
        cache(object, count);
    }

    /**
     * 缓存到数组头部,先右移
     *
     * @param object
     * @param end
     */
    public void cache(T object, int end) {
        //先右移一位
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * end左边的数据全部右移一位
     *
     * @param end
     */
    public void rightShift(int end) {
        for (int i = end - 1; i > 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * 判断数组是否满了
     *
     * @return
     */
    public boolean isFull() {
        return count == capacity;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 判断是否包含key
     *
     * @param object
     * @return
     */
    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUBasedArray<Integer> array = new LRUBasedArray<>(5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            array.offer(scanner.nextInt());
            System.out.println(array.toString());
        }
    }
}
