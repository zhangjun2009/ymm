package com.zhangj.ymm.work;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) {
        PotentialDealerPO po = new PotentialDealerPO();
        po.setCustId(10055L);
        po.setCity(1002L);
        po.setCustLevel(1);
        po.setCustMeetTime(System.currentTimeMillis());
        po.setPrincipalPhone("17751799624");
        po.setSalesId(550045L);
        po.setCustName("本田进销商");
        po.setIntention(2);
        PotentialDealerDTO dto = new PotentialDealerDTO();
        dto.setOptType(1);
        dto.setPotentialDealerPO(po);
        System.out.println(JSONObject.toJSONString(dto));
    }
}
