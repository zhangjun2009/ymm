package com.zhangj.ymm.thread.demo2.two_phase_termination;

import java.io.IOException;

/**
 * @author zhangj
 * @date 2019/3/18
 */
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer appServer = new AppServer(3324);
        appServer.start();
        Thread.sleep(15_000);
        appServer.shutDown();
    }
}
