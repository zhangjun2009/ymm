package com.zhangj.ymm.rocketmq.example4;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author zhangj
 * @date 2019/2/3
 * @description: TODO
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("pull_producer");
        producer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("TopicPull", "TagA", ("Hello Rocket " + i).getBytes());
            try {
                SendResult sendResult = producer.send(message);
                System.out.println(sendResult);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}
