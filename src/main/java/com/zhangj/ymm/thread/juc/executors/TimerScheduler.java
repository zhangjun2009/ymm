package com.zhangj.ymm.thread.juc.executors;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/23
 */
public class TimerScheduler {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=======" + System.currentTimeMillis());
            }
        };
        timer.schedule(timerTask, 1000, 100);

    }
}
