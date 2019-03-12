package com.zhangj.ymm.rocketmq.example1;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * @author zhangj
 * @date 2019/1/31
 * @description: TODO
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producter_group");
        producer.setNamesrvAddr("192.168.35.51:9876;192.168.35.199:9876");
        producer.start();

        for (int i = 1; i <= 1; i++) {
            Message message = new Message("topic", "tag", "key", ("CRM " + i).getBytes());
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
