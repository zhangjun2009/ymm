package com.zhangj.ymm.thread.part1.part1;

/**
 * @author zhangj
 * @date 2019/3/12
 * Thread类使用的是策略模式,各自实现自己的run()方法,类似一下代码
 */
public abstract class TempleteMethod {
    public static void main(String[] args) {
        TempleteMethod templeteMethod = new TempleteMethod() {
            @Override
            protected void printll() {
                System.out.println("+++++Hello+++++");
            }
        };
        templeteMethod.println();
    }

    public void println() {
        System.out.println("************************");
        printll();
        System.out.println("************************");
    }

    protected abstract void printll();
}
