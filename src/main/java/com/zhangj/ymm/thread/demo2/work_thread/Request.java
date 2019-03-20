package com.zhangj.ymm.thread.demo2.work_thread;

import lombok.Data;

/**
 * @author zhangj
 * @date 2019/3/20
 */
@Data
public class Request {
    private final String name;
    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executed " + this);
    }

    @Override
    public String toString() {
        return "name=" + name + " NO=" + number;
    }
}
