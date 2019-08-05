package com.zhangj.creational.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class PromotionStrategyFactory {
    private static final Map<String, PromotionStrategy> PROMOTIONSTRATEGY_MAP = new HashMap<>();

    static {
        PROMOTIONSTRATEGY_MAP.put("fanxian", new FanxianPromotionStrategy());
        PROMOTIONSTRATEGY_MAP.put("lijian", new LijianPromotionStrategy());
        PROMOTIONSTRATEGY_MAP.put("manjian", new ManjianPromotionStrategy());
    }

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String key) {
        return PROMOTIONSTRATEGY_MAP.get(key);
    }
}
