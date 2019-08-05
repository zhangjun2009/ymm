package com.zhangj.creational.strategy;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class LijianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotionStrategy() {
        System.out.println("立减促销活动");
    }
}
