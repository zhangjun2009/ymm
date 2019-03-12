package com.zhangj.ymm.thread.part2.read_write_lock;

/**
 * @author zhangj
 * @date 2019/3/9
 */
public class ShardData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public ShardData(int length) {
        this.buffer = new char[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return this.doRead();
        } finally {
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        } finally {
            lock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }

    private char[] doRead() {
        char[] newBuff = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuff[i] = buffer[i];
        }
        slowly(50);
        return newBuff;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
