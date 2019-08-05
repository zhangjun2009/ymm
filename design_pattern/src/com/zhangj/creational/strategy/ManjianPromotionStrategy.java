package com.zhangj.creational.strategy;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class ManjianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotionStrategy() {
        System.out.println("满减促销活动");
    }
}
