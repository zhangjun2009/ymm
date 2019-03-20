package com.zhangj.ymm.thread.demo2.work_thread;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class Client {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();
        new TransportThread("zhang", channel).start();
        new TransportThread("xu", channel).start();
        new TransportThread("chen", channel).start();
    }
}
