package com.zhangj.ymm.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/7/18
 */
public class PriceLadder implements Serializable {
    private Long priceRangeStart;
    private Long priceRangeEnd;
    private List<PrizesConfig> subList;

    public List<PrizesConfig> getSubList() {
        return subList;
    }

    public void setSubList(List<PrizesConfig> subList) {
        this.subList = subList;
    }

    public Long getPriceRangeStart() {
        return priceRangeStart;
    }

    public void setPriceRangeStart(Long priceRangeStart) {
        this.priceRangeStart = priceRangeStart;
    }

    public Long getPriceRangeEnd() {
        return priceRangeEnd;
    }

    public void setPriceRangeEnd(Long priceRangeEnd) {
        this.priceRangeEnd = priceRangeEnd;
    }
}
