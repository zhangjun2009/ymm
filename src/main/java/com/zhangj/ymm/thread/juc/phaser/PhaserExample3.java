package com.zhangj.ymm.thread.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class PhaserExample3 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);

        for (int i = 1; i < 5; i++) {
            new PhaserExample2.Athletes(i, phaser).start();
        }
        new InjuredAthletes(6, phaser).start();
    }

    static class Athletes extends Thread {
        private final int no;
        private final Phaser phaser;

        Athletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(phaser, no, ": start running......", ": end running......");
                sport(phaser, no, ": start bicycle......", ": end bicycle......");
                sport(phaser, no, ": start long jump......", ": end long jump......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class InjuredAthletes extends Thread {
        private final int no;
        private final Phaser phaser;

        InjuredAthletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(phaser, no, ": start running......", ": end running......");
                sport(phaser, no, ": start bicycle......", ": end bicycle......");
                System.out.println("Oh shit,i am injured.");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sport(Phaser phaser, int no, String s, String s2) throws InterruptedException {
        System.out.println(no + s);
        TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
        System.out.println(no + s2);
        phaser.arriveAndAwaitAdvance();
    }
}
