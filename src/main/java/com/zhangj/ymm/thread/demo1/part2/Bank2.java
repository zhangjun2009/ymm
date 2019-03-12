package com.zhangj.ymm.thread.demo1.part2;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class Bank2 {
    public static void main(String[] args) {
        TicketWindow2 ticketWindow2 = new TicketWindow2();
        Thread t1 = new Thread(ticketWindow2);
        Thread t2 = new Thread(ticketWindow2);
        Thread t3 = new Thread(ticketWindow2);
        t1.start();
        t2.start();
        t3.start();
    }
}
