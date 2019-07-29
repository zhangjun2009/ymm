package com.zhangj.creational.factorymethod;

/**
 * @author zhangj
 * @date 2019/7/27
 */
public class PhpVideoFactory extends VideoFactory {
    @Override
    public Video create() {
        return new PhpVideo();
    }
}
