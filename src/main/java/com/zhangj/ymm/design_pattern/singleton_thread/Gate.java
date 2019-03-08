package com.zhangj.ymm.design_pattern.singleton_thread;


/**
 * @author zhangj
 * @date 2019/3/8
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.name = name;
        this.address = address;
        this.counter++;
        verify();
    }

    public void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*********BROKEN***********" + printString());
        }
    }

    public synchronized String printString() {
        return "No." + counter + ":" + name + "," + address;
    }
}
