package com.zhangj.creational.bridge;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public class Test {
    public static void main(String[] args) {
        ICBCBank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();
    }
}
