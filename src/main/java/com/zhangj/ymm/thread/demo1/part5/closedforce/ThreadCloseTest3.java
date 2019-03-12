package com.zhangj.ymm.thread.demo1.part5.closedforce;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class ThreadCloseTest3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadService.shutDowm(5_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
