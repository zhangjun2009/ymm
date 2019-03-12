package com.zhangj.ymm.rocketmq.example3;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/2/3
 * @description: TODO
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("transaction_producer");
        //nameserver服务
        producer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876");
        //事务回查最小并发数
        producer.setCheckThreadPoolMinSize(5);
        //事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(20);
        //队列数
        producer.setCheckRequestHoldMax(2000);
        //服务器回调producer,检查本地事务分支成功还是失败
        producer.setTransactionCheckListener(new TransactionCheckListener() {
            @Override
            public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
                System.out.println("state--" + new String(msg.getBody()));
                //if数据入库真实发生变化,则再次提交状态
                //else 数据库没有发生变化,则直接忽略该数据回滚即可
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        /**
         * producer对象在使用之前必须调用start()初始化,初始化一次即可
         * 注意:切记不可以在每次发送消息时,都调用start()方法
         */
        producer.start();

        TransactionExecuterImpl transactionExecuter = new TransactionExecuterImpl();

        for (int i = 1; i <= 1; i++) {
            Message message = new Message("TopicTransaction", "Transaction" + i, "Key", ("Hello Rocket" + i).getBytes());
            TransactionSendResult sendResult = producer.sendMessageInTransaction(message, transactionExecuter, "zhangj");
            System.out.println(sendResult);
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        /**
         * 应用退出时,要调用shutdown来清理资源,关闭网络链接
         */
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                producer.shutdown();
            }
        }));
        System.exit(0);
    }
}
