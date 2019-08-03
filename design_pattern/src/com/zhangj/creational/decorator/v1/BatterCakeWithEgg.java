package com.zhangj.creational.decorator.v1;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class BatterCakeWithEgg extends BatterCake {
    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
