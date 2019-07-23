package com.zhangj.ymm.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/7/11
 */
public class LongShortDistanceRaffleConfig implements Serializable {
    /**
     * 优先级
     */
    private Integer level;
    /**
     * 加价窗口
     */
    private String increaseWindowStart;
    private String increaseWindowEnd;

    /**
     * 订单线路
     */
    private List<LineRoad> lineRoad;

    /**
     * 加价阶梯
     */
    private List<PriceLadder> priceLadder;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIncreaseWindowStart() {
        return increaseWindowStart;
    }

    public void setIncreaseWindowStart(String increaseWindowStart) {
        this.increaseWindowStart = increaseWindowStart;
    }

    public String getIncreaseWindowEnd() {
        return increaseWindowEnd;
    }

    public void setIncreaseWindowEnd(String increaseWindowEnd) {
        this.increaseWindowEnd = increaseWindowEnd;
    }

    public List<LineRoad> getLineRoad() {
        return lineRoad;
    }

    public void setLineRoad(List<LineRoad> lineRoad) {
        this.lineRoad = lineRoad;
    }

    public List<PriceLadder> getPriceLadder() {
        return priceLadder;
    }

    public void setPriceLadder(List<PriceLadder> priceLadder) {
        this.priceLadder = priceLadder;
    }
}
