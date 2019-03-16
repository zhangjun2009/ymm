package com.zhangj.ymm.thread.demo2.guarded_suspension;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ClientThread extends Thread {
    private final RequestQueue queue;
    private final String sendValue;
    private final Random random;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.sendValue = sendValue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            System.out.println("Client -> request " + sendValue);
            this.queue.putRequest(new Request(sendValue));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
