package com.zhangj.ymm.hutool.map;

import cn.hutool.core.lang.Console;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class Fish implements Animal {
    @Override
    public void eat() {
        Console.log("猫吃鱼");
    }
}
