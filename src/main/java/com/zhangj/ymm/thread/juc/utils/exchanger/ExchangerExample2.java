package com.zhangj.ymm.thread.juc.utils.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author zhangj
 * @date 2019/4/11
 */
public class ExchangerExample2 {
    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread() {
            @Override
            public void run() {
                Object aobj = new Object();
                System.out.println("A will send the object " + aobj);
                try {
                    Object robj = exchanger.exchange(aobj);
                    System.out.println("A received the object " + robj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Object bobj = new Object();
                System.out.println("B will send the object " + bobj);
                try {
                    Object robj = exchanger.exchange(bobj);
                    System.out.println("B received the object " + robj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
