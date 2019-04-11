package com.zhangj.ymm.thread.juc.utils.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author zhangj
 * @date 2019/4/11
 */
public class ExchangerExample1 {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    String result = exchanger.exchange("I am come from T-A.");
                    System.out.println(Thread.currentThread().getName() + " get value=" + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end.");
            }
        }, "===A===").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(50000);
                    String result = exchanger.exchange("I am come from T-B.");
                    System.out.println(Thread.currentThread().getName() + " get value=" + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end.");
            }
        }, "===B===").start();
    }
}
