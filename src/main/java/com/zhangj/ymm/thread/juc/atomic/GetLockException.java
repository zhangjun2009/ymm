package com.zhangj.ymm.thread.juc.atomic;

/**
 * @author zhangj
 * @date 2019/3/31
 */
public class GetLockException extends Exception {

    public GetLockException() {
        super();
    }

    public GetLockException(String message) {
        super(message);
    }
}
