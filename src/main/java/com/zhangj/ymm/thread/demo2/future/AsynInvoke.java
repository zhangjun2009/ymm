package com.zhangj.ymm.thread.demo2.future;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class AsynInvoke {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "SUCCESS";
        });
        System.out.println("===================================");
        System.out.println("do other things......");
        Thread.sleep(1000);
        System.out.println("===================================");
        System.out.println(future.get());
    }
}
