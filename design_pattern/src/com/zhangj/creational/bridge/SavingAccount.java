package com.zhangj.creational.bridge;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("这是一个活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
