package com.zhangj.creational.facade;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("资格校验通!");
        return true;
    }
}
