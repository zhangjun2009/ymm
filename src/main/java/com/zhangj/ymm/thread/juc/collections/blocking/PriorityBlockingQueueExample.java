package com.zhangj.ymm.thread.juc.collections.blocking;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhangj
 * @date 2019/5/7
 */
public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        testAdd();
    }

    private static <T> PriorityBlockingQueue<T> create(int size) {
        return new PriorityBlockingQueue<>(size);
    }

    private static void testAdd() {
        PriorityBlockingQueue<Integer> queue = create(3);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.size());
    }
}
