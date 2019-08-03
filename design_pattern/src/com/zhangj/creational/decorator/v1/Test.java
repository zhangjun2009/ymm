package com.zhangj.creational.decorator.v1;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getDesc() + ",价格:" + batterCake.cost());

        BatterCakeWithEgg batterCakeWithEgg = new BatterCakeWithEgg();
        System.out.println(batterCakeWithEgg.getDesc() + ",价格:" + batterCakeWithEgg.cost());

        BatterCakeWithSuasage batterCakeWithSuasage = new BatterCakeWithSuasage();
        System.out.println(batterCakeWithSuasage.getDesc() + ",价格:" + batterCakeWithSuasage.cost());
    }
}
