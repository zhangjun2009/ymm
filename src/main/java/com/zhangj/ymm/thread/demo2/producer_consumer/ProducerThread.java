package com.zhangj.ymm.thread.demo2.producer_consumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangj
 * @date 2019/3/17
 */
public class ProducerThread extends Thread {
    private final MessageQueue queue;
    private final static Random random = new Random(System.currentTimeMillis());
    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue queue, int seq) {
        super("PRODUCER-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("Message-" + counter.getAndIncrement());
                queue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
