package com.zhangj.ymm.thread.demo2.guarded_suspension;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ServerClient extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private volatile boolean flag = false;

    public ServerClient(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!flag) {
            Request request = queue.getRequest();
            if (null == request) {
                System.out.println("Received the empty request.");
                continue;
            }
            System.out.println("server -> " + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close() {
        this.flag = true;
        this.interrupt();
    }
}
