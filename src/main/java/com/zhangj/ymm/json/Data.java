package com.zhangj.ymm.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author zhangj
 * @date 2019/7/22
 */
public class Data {
    public static void main(String[] args) {
        String json = "[{\"touchUpConfigItems\":[],\"awardOrder\":1,\"awardInfo\":\"{\\\"value\\\":0,\\\"name\\\":\\\"\\\",\\\"allowMax\\\":\\\"\\\",\\\"delayType\\\":1,\\\"delayMinutes\\\":\\\"\\\",\\\"delayDay\\\":\\\"\\\"}\",\"awardName\":\"\",\"awardRate\":\"\",\"awardImg\":\"\",\"totalCount\":-1,\"isDefault\":1,\"awardType\":305,\"extensionInfo\":\"{\\\"awardImgBig\\\":\\\"\\\",\\\"buttonName\\\":\\\"\\\",\\\"ymmUrl\\\":\\\"\\\",\\\"hcbUrl\\\":\\\"\\\"}\",\"lineRoad\":[{\"from\":[0],\"to\":[0]}],\"priceLadder\":[{\"key\":0,\"priceRangeStart\":1,\"priceRangeEnd\":10000,\"subList\":[{\"key\":0,\"waitTime\":1,\"prizesName\":\"12\",\"redPacketAmount\":12,\"perMaxNum\":1}]},{\"key\":1,\"priceRangeStart\":10000,\"priceRangeEnd\":50000,\"subList\":[{\"key\":0,\"waitTime\":2,\"prizesName\":\"232\",\"prizesNum\":null,\"redPacketAmount\":2,\"perMaxNum\":2}]}],\"increaseWindow\":[\"2019-07-21T16:37:18.000Z\",\"2019-07-22T15:37:18.000Z\"],\"awardNature\":2,\"usableCount\":-1,\"prizeType\":305,\"level\":1,\"increaseWindowStart\":\"00:37:18\",\"increaseWindowEnd\":\"23:37:18\"}]";
        List<LongShortDistanceRaffleConfig> raffleConfigList = JSON.parseObject(json, new TypeReference<List<LongShortDistanceRaffleConfig>>() {
        });
        System.out.println(raffleConfigList);
    }
}
