package com.zhangj.creational.prototype.v2;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pig pig = new Pig();
        pig.setName("zzz");
        pig.setBirthDay(new Date(0));
        Pig clone = (Pig) pig.clone();
        System.out.println(pig == clone);
    }
}
