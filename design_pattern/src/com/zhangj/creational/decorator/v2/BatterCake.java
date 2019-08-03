package com.zhangj.creational.decorator.v2;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class BatterCake extends ABatterCake {
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}
