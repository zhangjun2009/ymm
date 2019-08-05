package com.zhangj.creational.strategy;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionActivity() {
        promotionStrategy.doPromotionStrategy();
    }
}
