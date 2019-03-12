package com.zhangj.ymm.thread.part1.part2;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class Bank1 {
    public static void main(String[] args) {
        new TicketWindow1("窗口一").start();
        new TicketWindow1("窗口二").start();
        new TicketWindow1("窗口三").start();
    }
}
