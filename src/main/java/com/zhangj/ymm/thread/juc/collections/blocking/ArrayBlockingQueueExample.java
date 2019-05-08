package com.zhangj.ymm.thread.juc.collections.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhangj
 * @date 2019/5/5
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
//        testAddNotExceedCapacity();
//        testOffer();
        testPut();
//        testPeek();
//        testPool();
    }

    private static void testPut() throws InterruptedException {
        ArrayBlockingQueue<String> queue = create(3);
        queue.put("1");
        queue.put("2");
        //queue.put("3");
        if (queue.remainingCapacity() > 0) {
            System.out.println("111");
        }
        queue.put("4");
        queue.stream().forEach(System.out::println);
    }

    private static void testPool() throws InterruptedException {
        ArrayBlockingQueue<String> queue = create(3);
        queue.put("1");
        queue.put("2");
        queue.put("3");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void testPeek() throws InterruptedException {
        ArrayBlockingQueue<String> queue = create(3);
        queue.put("1");
        queue.put("2");
        queue.put("3");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }


    private static void testOffer() {
        ArrayBlockingQueue<String> queue = create(3);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.stream().forEach(System.out::println);
    }

    private static void testAddNotExceedCapacity() {
        ArrayBlockingQueue<String> queue = create(3);
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.size());
        queue.stream().forEach(System.out::println);
    }

    private static void testAddExceedCapacity() {
        ArrayBlockingQueue<String> queue = create(3);
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
    }

    public static <T> ArrayBlockingQueue<T> create(int size) {
        return new ArrayBlockingQueue<>(size);
    }
}
