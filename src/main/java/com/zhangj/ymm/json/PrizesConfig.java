package com.zhangj.ymm.json;

import java.io.Serializable;

/**
 * @author zhangj
 * @date 2019/7/18
 */
public class PrizesConfig implements Serializable {
    private Integer waitTime;
    private String prizesName;
    private Integer prizesNum;
    private Long redPacketAmount;
    private Integer perMaxNum;

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public String getPrizesName() {
        return prizesName;
    }

    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    public Integer getPrizesNum() {
        return prizesNum;
    }

    public void setPrizesNum(Integer prizesNum) {
        this.prizesNum = prizesNum;
    }

    public Long getRedPacketAmount() {
        return redPacketAmount;
    }

    public void setRedPacketAmount(Long redPacketAmount) {
        this.redPacketAmount = redPacketAmount;
    }

    public Integer getPerMaxNum() {
        return perMaxNum;
    }

    public void setPerMaxNum(Integer perMaxNum) {
        this.perMaxNum = perMaxNum;
    }
}
