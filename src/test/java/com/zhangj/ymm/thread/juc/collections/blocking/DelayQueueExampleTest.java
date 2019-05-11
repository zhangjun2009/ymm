package com.zhangj.ymm.thread.juc.collections.blocking;

import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/5/11
 */
public class DelayQueueExampleTest {

    @Test
    public void testAdd1() {
        DelayQueue<DelayElement<String>> delayQueue = DelayQueueExample.create();
        delayQueue.add(DelayElement.of("test1", 1000));
        System.out.println(delayQueue.size());
        System.out.println(delayQueue.peek());
    }

    @Test
    public void testAdd2() {
        DelayQueue<DelayElement<String>> delayQueue = DelayQueueExample.create();
        delayQueue.add(DelayElement.of("test1", 1000));
        delayQueue.add(DelayElement.of("test2", 800));
        delayQueue.add(DelayElement.of("test3", 11000));
        delayQueue.add(DelayElement.of("test4", 20000));
        long start = System.currentTimeMillis();
        Iterator<DelayElement<String>> iterator = delayQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testAdd3() {
        DelayQueue<DelayElement<String>> delayQueue = DelayQueueExample.create();
        delayQueue.add(DelayElement.of("test1", 1000));
        delayQueue.add(DelayElement.of("test2", 800));
        delayQueue.add(DelayElement.of("test3", 11000));
        delayQueue.add(DelayElement.of("test4", 20000));
        System.out.println(delayQueue.size());
        System.out.println(delayQueue.remove().getData());
    }

    @Test
    public void testAdd4() throws InterruptedException {
        DelayQueue<DelayElement<String>> delayQueue = DelayQueueExample.create();
        delayQueue.add(DelayElement.of("test1", 1000));
        delayQueue.add(DelayElement.of("test2", 800));
        delayQueue.add(DelayElement.of("test3", 11000));
        delayQueue.add(DelayElement.of("test4", 20000));
        System.out.println(delayQueue.take());
        System.out.println(delayQueue.take());
        System.out.println(delayQueue.take());
        System.out.println(delayQueue.take());
        System.out.println(delayQueue.take());
    }

    static class DelayElement<E> implements Delayed {
        private final E e;
        private final long expireTime;

        DelayElement(E e, long expireTime) {
            this.e = e;
            this.expireTime = System.currentTimeMillis() + expireTime;
        }

        static <T> DelayElement<T> of(T t, long delay) {
            return new DelayElement<>(t, delay);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = expireTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed delayedObject) {
            DelayElement that = (DelayElement) delayedObject;
            if (this.expireTime < that.getExpireTime()) {
                return -1;
            } else if (this.expireTime > that.getExpireTime()) {
                return 1;
            } else {
                return 0;
            }
        }

        public E getData() {
            return e;
        }

        public long getExpireTime() {
            return expireTime;
        }

        @Override
        public String toString() {
            return "DelayElement{" +
                    "e=" + e +
                    ", expireTime=" + expireTime +
                    '}';
        }
    }
}