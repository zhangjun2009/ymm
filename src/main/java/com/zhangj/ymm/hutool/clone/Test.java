package com.zhangj.ymm.hutool.clone;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
//        Cat clone = cat.clone();
//        System.out.println(cat.getDog() == clone.getDog());
        Cat byStream = ObjectUtil.cloneByStream(cat);
        System.out.println(cat == byStream);
        System.out.println(cat.getDog() == byStream.getDog());
    }
}
