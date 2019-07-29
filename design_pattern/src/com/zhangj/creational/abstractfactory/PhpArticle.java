package com.zhangj.creational.abstractfactory;

/**
 * @author zhangj
 * @date 2019/7/28
 */
public class PhpArticle extends Article {
    @Override
    public void produce() {
        System.out.println("录制php手记");
    }
}
