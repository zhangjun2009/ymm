package com.zhangj.ymm.rocketmq.example5;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author zhangj
 * @date 2019/2/6
 * @description: TODO
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("filter_group");
        producer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876");
        producer.start();
        try {
            for (int i = 0; i < 5; i++) {
                Message message = new Message("TopicFilter7", "TagA", "OrderId001", ("Hello RocketMQ" + i).getBytes());
                message.putUserProperty("SequenceId", String.valueOf(i));
                SendResult sendResult = producer.send(message);
                System.out.println(sendResult);
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
