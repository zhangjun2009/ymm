package com.zhangj.ymm.thread.demo1.part7;

/**
 * @author zhangj
 * @date 2019/3/13
 * 生产者消费者模式1
 */
public class ProducerConsumer1 {
    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1();
        new Thread(() -> {
            while (true) {
                producerConsumer1.produce();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                producerConsumer1.consume();
            }
        }).start();
    }

    private int index;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            System.out.println("P->" + (index++));
        }
    }

    public void consume() {
        synchronized (LOCK) {
            System.out.println("C->" + index);
        }
    }
}
