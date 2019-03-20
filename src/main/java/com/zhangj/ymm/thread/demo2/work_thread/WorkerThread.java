package com.zhangj.ymm.thread.demo2.work_thread;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class WorkerThread extends Thread {
    private final Channel channel;
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            channel.take().execute();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
