package com.zhangj.ymm.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/7/18
 */
public class LineRoad implements Serializable {
    private List<Integer> from;
    private List<Integer> to;

    public List<Integer> getFrom() {
        return from;
    }

    public void setFrom(List<Integer> from) {
        this.from = from;
    }

    public List<Integer> getTo() {
        return to;
    }

    public void setTo(List<Integer> to) {
        this.to = to;
    }
}
