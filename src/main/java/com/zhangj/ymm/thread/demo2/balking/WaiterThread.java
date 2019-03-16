package com.zhangj.ymm.thread.demo2.balking;

import java.io.IOException;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class WaiterThread extends Thread {
    private final BalkingData balkingData;

    public WaiterThread(BalkingData balkingData) {
        super("WaiterThread");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                balkingData.save();
                Thread.sleep(1_000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
