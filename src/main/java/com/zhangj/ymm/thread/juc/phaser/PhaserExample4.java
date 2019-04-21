package com.zhangj.ymm.thread.juc.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class PhaserExample4 {
    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return true;
            }
        };
        new OnAdvanceTask(phaser, "zhang").start();
        new OnAdvanceTask(phaser, "jun").start();

        //getPhase(phaser);
        //getRegisteredParties(phaser);
        //getArrivedParties(phaser);
        //bulkRegister(phaser);
    }

    static class OnAdvanceTask extends Thread {
        private final Phaser phaser;

        OnAdvanceTask(Phaser phaser, String name) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(getName() + " i am staring the phaser" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            System.out.println(getName() + " i am end");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " i am staring the phaser" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            System.out.println(getName() + " i am end");
        }
    }

    private static void bulkRegister(Phaser phaser) throws InterruptedException {
        phaser.bulkRegister(10);
        System.out.println(phaser.getRegisteredParties());
        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());
        new Thread(phaser::arriveAndAwaitAdvance).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("===============================");
        System.out.println(phaser.getRegisteredParties());
        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());
    }

    private static void getArrivedParties(Phaser phaser) {
        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());
    }

    private static void getRegisteredParties(Phaser phaser) {
        System.out.println(phaser.getRegisteredParties());
        phaser.register();
        System.out.println(phaser.getRegisteredParties());
        phaser.register();
        System.out.println(phaser.getRegisteredParties());
    }

    private static void getPhase(Phaser phaser) {
        System.out.println("getPhase=>" + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println("getPhase=>" + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println("getPhase=>" + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println("getPhase=>" + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
    }
}
