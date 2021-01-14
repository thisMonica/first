package com.example.first.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author hu
 * @date 2020/5/23 16:11
 * <p>
 * 消息的消费者
 */
public class Consumer2 {

    public static void main(String[] args) throws MQClientException {

//        1、创建消费者Consumer，指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup2");
//        2、指定Nameserver地址
        consumer.setNamesrvAddr("127.0.0.1:9876");
//        3、订阅主题Topic和Tag
        consumer.subscribe("sync", "Tag1");
        consumer.setConsumeMessageBatchMaxSize(2);
        // 设置消费模式：集群消费|广播模式(默认是集群消费模式)
//        consumer.setMessageModel(MessageModel.CLUSTERING);
//        4、设置回调函数、处理消费
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
//                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                for (Message message : msgs) {
                    String msg = new String(message.getBody());
                    System.out.println(msg);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
//        5、启动消费者consumer
        consumer.start();
    }


}
