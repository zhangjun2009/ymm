package com.zhangj.ymm.hutool.map;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class Test {
    public static void main(String[] args) {
        Animal fish = ProxyUtil.proxy(new Fish(), TimeIntervalAspect.class);
        fish.eat();
    }
}
