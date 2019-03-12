package com.zhangj.ymm.thread.demo2.future;

/**
 * @author zhangj
 * @date 2019/3/12
 * 同步调用
 */
public class SyncInvoke {
    public static void main(String[] args) throws InterruptedException {
        String str = get();
        System.out.println(str);
    }

    public static String get() throws InterruptedException {
        //耗时的操作
        Thread.sleep(10_000);
        return "FINISHED";
    }
}
