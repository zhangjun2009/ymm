package com.zhangj.creational.decorator.v1;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class BatterCakeWithSuasage extends BatterCake {
    @Override
    public String getDesc() {
        return super.getDesc() + "加个烤肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
