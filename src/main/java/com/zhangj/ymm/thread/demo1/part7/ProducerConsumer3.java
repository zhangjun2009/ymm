package com.zhangj.ymm.thread.demo1.part7;

import java.util.stream.Stream;

/**
 * @author zhangj
 * @date 2019/3/14
 */
public class ProducerConsumer3 {
    public static void main(String[] args) {
        ProducerConsumer3 producerConsumer3 = new ProducerConsumer3();
        Stream.of("P1", "P2", "P3").forEach(name -> {
            new Thread(() -> {
                while (true){
                    producerConsumer3.produce();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, name).start();
        });
        Stream.of("C1", "C2", "C3").forEach(name -> {
            new Thread(() -> {
                while (true){
                    producerConsumer3.consume();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, name).start();
        });
    }

    private int i;
    private final Object LOCK = new Object();
    private volatile boolean flag = false;

    public void produce() {
        synchronized (LOCK) {
            while (flag) {
                //已经生产,阻塞
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //没有生产
            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            //通知所有消费者
            LOCK.notifyAll();
            this.flag = true;
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!flag) {
                //没有生产,则阻塞
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //已经生产,则消费
            System.out.println(Thread.currentThread().getName() + "->" + i);
            //通知生产者
            LOCK.notifyAll();
            this.flag = false;
        }
    }

}
