package com.zhangj.creational.facade;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift();
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExange(pointsGift);
    }
}
