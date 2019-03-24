package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/24
 */
public class Singleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }

    public static int x = 0;
    public static int y;

    private static Singleton instance = new Singleton();

    public Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }
}
