package com.zhangj.ymm.thread.demo2.singleton_thread;

/**
 * @author zhangj
 * @date 2019/3/8
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User nj = new User("nanjinglao", "nanjing", gate);
        User bj = new User("beijinglao", "beijing", gate);
        User wh = new User("wuhulao", "wuhu", gate);
        nj.start();
        bj.start();
        wh.start();
    }
}
