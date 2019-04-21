package com.zhangj.ymm.thread.juc.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class PhaserExample6 {
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(6);
        IntStream.rangeClosed(0, 5).boxed().map(i -> phaser).forEach(AwaitAdvanceTask::new);
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("=========================");
    }

    static class AwaitAdvanceTask extends Thread {
        private final Phaser phaser;

        AwaitAdvanceTask(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
                phaser.arriveAndAwaitAdvance();
                System.out.println(getName() + " finished work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
