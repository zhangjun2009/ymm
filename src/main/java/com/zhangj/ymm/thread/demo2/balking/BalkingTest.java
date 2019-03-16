package com.zhangj.ymm.thread.demo2.balking;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class BalkingTest {
    public static void main(String[] args) {
        final BalkingData balkingData = new BalkingData("D:\\data\\zhangj.txt", "====BEGIN====");
        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
