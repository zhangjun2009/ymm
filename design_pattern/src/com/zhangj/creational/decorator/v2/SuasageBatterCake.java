package com.zhangj.creational.decorator.v2;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class SuasageBatterCake extends AbstractDecorator {
    public SuasageBatterCake(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加个烤肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
