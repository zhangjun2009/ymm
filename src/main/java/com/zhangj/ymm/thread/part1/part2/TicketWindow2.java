package com.zhangj.ymm.thread.part1.part2;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/3/12
 * 实现Runnable接口
 */
public class TicketWindow2 implements Runnable {
    /**
     * 窗口最大卖票数
     */
    private final static int MAX = 50;
    /**
     * 当前卖到第几号票
     */
    private int index = 1;

    @Override
    public synchronized void run() {
        while (index <= MAX) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "当前号码为:" + index++);
        }
    }
}
