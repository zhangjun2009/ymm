package com.zhangj.ymm.thread.part2.read_write_lock;

/**
 * @author zhangj
 * @date 2019/3/9
 */
public class ReadWriteLock {
    /**
     * 有多少个线程正在读
     */
    private int readingReaders = 0;
    /**
     * 有多少线程阻塞着,等待读
     */
    private int waitingReaders = 0;
    /**
     * 有多少线程正在写,肯定是一个
     */
    private int writingWriters = 0;
    /**
     * 有多少线程阻塞着,等待写
     */
    private int waitingWriters = 0;

    /**
     * 更偏好写操作
     */
    private boolean perferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean perferWriter) {
        this.perferWriter = perferWriter;
    }

    /**
     * 读锁
     */
    public synchronized void readLock() throws InterruptedException {
        //等待读的线程数++
        this.waitingReaders++;
        try {
            //如果有正在写的线程,不允许读
            while (writingWriters > 0 || (perferWriter && (waitingWriters > 0))) {
                this.wait();
            }
            //获得到读权限后,正在读的线程数++
            this.readingReaders++;
        } finally {
            //读动作完成后,等待读的线程数--
            this.waitingReaders--;
        }
    }

    /**
     * 读释放锁
     */
    public synchronized void readUnLock() {
        this.readingReaders--;
        this.notifyAll();
    }

    /**
     * 写锁
     */
    public synchronized void writeLock() throws InterruptedException {
        //等待写的线程数++
        this.waitingWriters++;
        try {
            //如果有正在写的线程或者读的线程,不允许写
            while (readingReaders > 0 || writingWriters > 0) {
                this.wait();
            }
            //获得写权限后,正在写的线程数++
            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    /**
     * 写锁释放
     */
    public synchronized void writeUnLock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
