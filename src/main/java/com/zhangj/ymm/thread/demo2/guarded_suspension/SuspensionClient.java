package com.zhangj.ymm.thread.demo2.guarded_suspension;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "zhangj").start();
        ServerClient serverClient = new ServerClient(queue);
        serverClient.start();
        //serverClient.join();
        Thread.sleep(10000);
        serverClient.close();
    }
}
