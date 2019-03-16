package com.zhangj.ymm.thread.demo2.thread_local;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Alex";
        }
    };

    public static void main(String[] args) {
        //threadLocal.set("zhangj");
        System.out.println(threadLocal.get());
    }
}
