package com.zhangj.ymm.thread.demo2.producer_consumer;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/17
 */
public class ConsumerThread extends Thread {
    private final MessageQueue queue;
    private final static Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue queue, int seq) {
        super("CONSUMER-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = queue.take();
                System.out.println(Thread.currentThread().getName() + " take a message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
