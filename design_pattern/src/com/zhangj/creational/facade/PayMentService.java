package com.zhangj.creational.facade;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class PayMentService {
    public boolean pay(PointsGift pointsGift) {
        System.out.println("积分支付成功");
        return true;
    }
}
