package com.zhangj.ymm.thread.demo1.part7;

/**
 * @author zhangj
 * @date 2019/3/13
 * 生产者消费者模式1
 */
public class ProducerConsumer2 {
    public static void main(String[] args) {
        ProducerConsumer2 producerConsumer1 = new ProducerConsumer2();
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
    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                //已经生产,则等待
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                //producer没有生产,则生产,并唤醒consumer
                System.out.println("P->" + (index++));
                LOCK.notify();
                this.isProduced = true;
            }


        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                //producer已经生产,则消费,并唤醒生产者
                System.out.println("C->" + index);
                LOCK.notify();
                this.isProduced = false;
            } else {
                //producer没有生产,则等待
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
