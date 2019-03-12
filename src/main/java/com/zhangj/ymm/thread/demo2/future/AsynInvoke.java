package com.zhangj.ymm.thread.demo2.future;

/**
 * @author zhangj
 * @date 2019/3/12
 * Future  ->  代表未来的一个凭据
 * FutureTask  -> 将自己的调用逻辑进行隔离
 * FutureService -> 桥接Future和FutureTask的作用
 */
public class AsynInvoke {
    public static void main(String[] args) throws InterruptedException {
        futureMethod();
        System.out.println("************************************");
        callbackMethod();
    }

    private static void futureMethod() throws InterruptedException {
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

    private static void callbackMethod() throws InterruptedException {
        FutureService futureService = new FutureService();
        futureService.submit(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "SUCCESS";
        }, System.out::println);
        System.out.println("===================================");
        System.out.println("do other things......");
        Thread.sleep(1000);
        System.out.println("===================================");
    }
}
