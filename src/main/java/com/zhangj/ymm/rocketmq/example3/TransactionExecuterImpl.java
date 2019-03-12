package com.zhangj.ymm.rocketmq.example3;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author zhangj
 * @date 2019/2/3
 * @description: TODO
 */
public class TransactionExecuterImpl implements LocalTransactionExecuter {
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
        System.out.println(msg.toString());
        System.out.println("msg=" + new String(msg.getBody()));
        System.out.println("arg=" + arg);
        String tags = msg.getTags();
        System.out.println("这里执行入库操作...入库成功...");
        return LocalTransactionState.ROLLBACK_MESSAGE;
    }
}
