package com.zhangj.ymm.rocketmq.example4;

import com.alibaba.rocketmq.client.consumer.MQPullConsumer;
import com.alibaba.rocketmq.client.consumer.MQPullConsumerScheduleService;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.PullTaskCallback;
import com.alibaba.rocketmq.client.consumer.PullTaskContext;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author zhangj
 * @date 2019/2/3
 * @description: TODO
 */
public class PullScheduleService {
    public static void main(String[] args) throws MQClientException {
        MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService("schedule_consumer");
        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876");
        scheduleService.setMessageModel(MessageModel.CLUSTERING);
        scheduleService.registerPullTaskCallback("TopicPull", new PullTaskCallback() {
            @Override
            public void doPullTask(MessageQueue mq, PullTaskContext context) {
                MQPullConsumer consumer = context.getPullConsumer();
                //获取从哪里拉取
                try {
                    long offset = consumer.fetchConsumeOffset(mq, false);
                    if (offset < 0)
                        offset = 0;
                    PullResult pullResult = consumer.pull(mq, "*", offset, 32);
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            List<MessageExt> list = pullResult.getMsgFoundList();
                            for (MessageExt msg : list) {
                                //消费数据
                                System.out.println(new String(msg.getBody()));
                            }
                            break;
                        case NO_NEW_MSG:
                            System.out.println("没有新数据...");
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                    //存储offset,客户端每隔5秒会定时刷新到broker
                    consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
                    //设置再过3000ms后重新拉取
                    context.setPullNextDelayTimeMillis(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        scheduleService.start();
        System.out.println("Pull Consumer Started");
    }
}
