package com.zhangj.ymm.rocketmq.example2;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/2/3
 * @description: TODO
 */
public class producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("order_producer");
        producer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876");
        producer.start();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        for (int i = 0; i < 5; i++) {
            String body = dateStr + " Hello RocketMQ " + i;
            Message message = new Message("TopicOrder", "Taga", "Key" + i, body.getBytes());
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    System.out.println("id:" + id);
                    return mqs.get(id);
                }
            }, 1);
            System.out.println(sendResult + ",body:" + body);
        }
        producer.shutdown();
    }
}
