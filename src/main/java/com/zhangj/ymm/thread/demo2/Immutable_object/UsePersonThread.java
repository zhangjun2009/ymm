package com.zhangj.ymm.thread.demo2.Immutable_object;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
