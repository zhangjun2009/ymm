package com.zhangj.ymm.rocketmq.example5;

import com.alibaba.rocketmq.common.filter.MessageFilter;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * @author zhangj
 * @date 2019/2/6
 * @description: TODO
 */
public class MessageFilterImpl implements MessageFilter {
    @Override
    public boolean match(MessageExt msg) {
        //NO Chinese
        System.out.println("------------------");
        String property = msg.getUserProperty("SequenceId");
        System.out.println("------------" + property);
        if (property != null) {
            int id = Integer.parseInt(property);
            if (id % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}
