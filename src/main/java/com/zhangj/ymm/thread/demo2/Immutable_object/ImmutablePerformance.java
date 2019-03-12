package com.zhangj.ymm.thread.demo2.Immutable_object;

/**
 * @author zhangj
 * @date 2019/3/12
 * 测试不可变对象 和 synch 之间的性能区别
 */
public class ImmutablePerformance {
    public static void main(String[] args) {
        syncMethod();
        ImmutableMethod();
    }

    private static void syncMethod() {
        long startTime = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("zhangj");
        for (long i = 0; i < 10000000L; i++) {
            syncObj.toString();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("SyncObj used times " + (endTime - startTime));
    }

    private static void ImmutableMethod() {
        long startTime = System.currentTimeMillis();
        ImmutableObj syncObj = new ImmutableObj("lisi");
        for (long i = 0; i < 10000000L; i++) {
            syncObj.toString();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ImmutableObj used times " + (endTime - startTime));
    }

    /**
     * 不可变对象
     */
    final static class ImmutableObj {
        private final String name;

        ImmutableObj(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "[" + name + "]";
        }
    }

    /**
     * 可变对象加锁
     */
    static class SyncObj {
        private String name;

        public synchronized void setName(String name) {
            this.name = name;
        }

        @Override
        public synchronized String toString() {
            return "[" + name + "]";
        }
    }
}
