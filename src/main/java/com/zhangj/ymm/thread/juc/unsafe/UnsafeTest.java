package com.zhangj.ymm.thread.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/2
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException {
        counterNumber(new UnsafeCounter(), "UnsafeCounter");
        counterNumber(new StupidCounter(), "StupidCounter");
        counterNumber(new SyncCounter(), "SyncCounter");
        counterNumber(new LockCounter(), "LockCounter");
        counterNumber(new AtomicCounter(), "AtomicCounter");
    }

    private static void counterNumber(Counter counter, String name) {
        List<Thread> threadList = new ArrayList<>(1000);
        List<Long> result = new ArrayList<>(1000);
        IntStream.rangeClosed(1, 10).forEach(v -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                Thread thread = new Thread(new CounterRunnable(counter, 10000));
                thread.start();
                threadList.add(thread);
            }
            threadList.stream().forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            long processTime = System.currentTimeMillis() - start;
            //System.out.println("第" + v + "次Counter result:" + counter.getCounter());
            //System.out.println("第" + v + "次Time pass in ms:" + processTime);
            //System.out.println("=================================");
            result.add(processTime);
        });
        System.out.println(name + " avg process times: [" + result.stream().collect(Collectors.averagingDouble(Long::longValue)) + "] ms");
    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    interface Counter {
        void increment();

        long getCounter();
    }

    static class StupidCounter implements Counter {
        private long counter;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class UnsafeCounter implements Counter {
        private volatile long counter;
        private Unsafe unsafe;
        private long offset;

        public UnsafeCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(UnsafeCounter.class.getDeclaredField("counter"));
        }

        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCounter implements Counter {
        private AtomicLong counter = new AtomicLong();

        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class SyncCounter implements Counter {
        private long counter;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class LockCounter implements Counter {
        private long counter;
        private final Lock lock = new ReentrantLock();

        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class CounterRunnable implements Runnable {
        private final Counter counter;
        private final int num;

        CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }
}
