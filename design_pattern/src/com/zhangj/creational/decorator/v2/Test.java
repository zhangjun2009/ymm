package com.zhangj.creational.decorator.v2;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) {
        ABatterCake aBatterCake = new BatterCake();
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new SuasageBatterCake(aBatterCake);
        System.out.println(aBatterCake.getDesc() + " 销售价格:" + aBatterCake.cost());

    }
}
