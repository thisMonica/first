package com.example.first.mq.producer;

import com.example.first.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.Arrays;
import java.util.List;

/**
 * @author hu
 * @date 2020/5/23 23:39
 */
@Slf4j
public class SeqProducer {
    static List<User> users;

    static {
        User user1 = new User("1", "one", "132", "深圳", "25");
        User user2 = new User("2", "two", "138", "深圳", "26");
        User user3 = new User("3", "three", "136", "深圳", "21");
        User user4 = new User("4", "Four", "157", "深圳", "24");
        User user5 = new User("5", "five", "186", "深圳", "23");
        users = Arrays.asList(user1, user2, user3, user4, user5);
    }


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setProducerGroup("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < users.size(); i++) {
            Message message = new Message("base", "user", "i" + i, users.get(i).toString().getBytes());
            //参数一：消息对象
            //参数二：消息队列选择器
            //参数三：选择队列的业务标识，比如订单id

            SendResult send = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object arg) {
                    long userId = Long.parseLong((String) arg);
                    long index = userId % users.size();
                    return list.get((int) index);
                }
            }, users.get(i).getId());
            log.info("发送状态:{}", send.getSendStatus());
        }
    }

}
