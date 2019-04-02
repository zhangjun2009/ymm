package com.zhangj.ymm.thread_pool;

/**
 * @author zhangj
 * @date 2019/4/2
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        int i = 4;
        if (i > 3) {
            System.out.println("1");
        } else if (i > 5) {
            System.out.println("2");
        } else {
            System.out.println("3");
        }
       /* ForkJoinPool forkJoinPool = new ForkJoinPool();
        InfoCustomerRecursiveAction action;
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(i);
        }
        action = new InfoCustomerRecursiveAction(0, 100, data, 10);
        forkJoinPool.invoke(action);
        System.out.println("working finish......");
        forkJoinPool.shutdown();*/
    }
}
