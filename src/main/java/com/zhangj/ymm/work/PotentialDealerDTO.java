package com.zhangj.ymm.work;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangj
 * @date 2019/3/14
 */
@Data
public class PotentialDealerDTO implements Serializable {
    /**
     * 操作类型
     */
    private int optType;
    /**
     * 操作的po
     */
    private PotentialDealerPO potentialDealerPO;


}
