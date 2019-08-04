package com.zhangj.creational.bridge;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public abstract class Bank {
    public Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
