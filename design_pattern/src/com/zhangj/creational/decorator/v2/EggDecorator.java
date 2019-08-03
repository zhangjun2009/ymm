package com.zhangj.creational.decorator.v2;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
