package com.zhangj.ymm.thread.demo2.producer_consumer;

/**
 * @author zhangj
 * @date 2019/3/17
 */
public class ProducerAndConsumerClient {
    public static void main(String[] args) {
        final MessageQueue queue = new MessageQueue();
        new ProducerThread(queue, 1).start();
        new ConsumerThread(queue, 1).start();
    }
}
