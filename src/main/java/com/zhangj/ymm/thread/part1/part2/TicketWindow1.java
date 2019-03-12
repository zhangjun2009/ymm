package com.zhangj.ymm.thread.part1.part2;

/**
 * @author zhangj
 * @date 2019/3/12
 * 继承Thread类
 */
public class TicketWindow1 extends Thread {
    /**
     * 窗口名称
     */
    private final String name;
    /**
     * 窗口最大卖票数
     */
    private final static int MAX = 50;
    /**
     * 当前卖到第几号票
     */
    private int index = 1;

    public TicketWindow1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(name + "当前号码为:" + index++);
        }
    }
}
