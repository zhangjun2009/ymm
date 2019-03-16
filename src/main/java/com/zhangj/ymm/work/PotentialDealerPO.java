package com.zhangj.ymm.work;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangj
 * @date 2019/3/14
 */
@Data
public class PotentialDealerPO implements Serializable {
    /**
     * 客户id
     */
    private Long custId;
    /**
     * 销售id
     */
    private Long salesId;
    /**
     * 客户所在市
     */
    private Long city;
    /**
     * 客户等级
     */
    private Integer custLevel;
    /**
     * 负责人手机号
     */
    private String principalPhone;
    /**
     * 预约时间
     */
    private Long custMeetTime;
    /**
     * 公司名称
     */
    private String custName;
    /**
     * 签约意向
     */
    private Integer intention;
}
