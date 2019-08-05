package com.zhangj.creational.strategy;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class FanxianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotionStrategy() {
        System.out.println("返现促销活动");
    }
}
