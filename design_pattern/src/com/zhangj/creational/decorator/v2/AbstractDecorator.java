package com.zhangj.creational.decorator.v2;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class AbstractDecorator extends ABatterCake {
    private ABatterCake aBatterCake;

    public AbstractDecorator(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    @Override
    public String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    public int cost() {
        return this.aBatterCake.cost();
    }
}
