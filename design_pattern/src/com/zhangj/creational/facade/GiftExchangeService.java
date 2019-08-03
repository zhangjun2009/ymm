package com.zhangj.creational.facade;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class GiftExchangeService {
    private QualifyService qualifyService = new QualifyService();
    private PayMentService payMentService = new PayMentService();
    private ShipperService shipperService = new ShipperService();

    public void giftExange(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            if (payMentService.pay(pointsGift)) {
                shipperService.shipGift(pointsGift);
            }
        }
    }
}
