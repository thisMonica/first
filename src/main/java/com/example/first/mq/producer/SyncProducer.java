package com.example.first.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * @author hu
 * @date 2020/5/23 15:57
 * <p>
 * 发送同步消息
 */
@Slf4j
public class SyncProducer {


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        1、创建消息生产者prouducer,并指定生产组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
//        2、指定Nameserver地址
        producer.setNamesrvAddr("127.0.0.1:9876");
//        3、启动producer
        producer.start();
//        4、创建消息对象，指定主题Topic、Tag和消息体
        for (int i = 0; i < 10; i++) {
            //先发十个
            //参数一：消息主题Topic
            //参数二：消息Tag
            //参数三：消息内容
            Message msg = new Message("sync", "Tag1", "Hello RocketMq".getBytes());
//            5、发送消息
            SendResult result = producer.send(msg);
            SendStatus status = result.getSendStatus();
            String msgId = result.getMsgId();
            int queueId = result.getMessageQueue().getQueueId();
            log.info("发送状态:{},消息id:{},消息接收队列id:{}", status, msgId, queueId);
            TimeUnit.SECONDS.sleep(1);
        }
//        6、关闭生产者producer
        producer.shutdown();
    }


}
