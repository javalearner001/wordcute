package com.sun.wordcute.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @ClassName RocketMqProducer
 * @Description TODO
 * @Author sunkai
 * @Date 2020/4/2 14:26
 * @Version 1.0
 **/
public class RocketMqProducer {



    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("sun_producer_group");
        producer.setNamesrvAddr("192.168.26.128:9876");//从命名服务器拿到broker的地址
        producer.start();

        int num = 0;
        while (num < 20){
            num++;
            //topic 主题
            //tag:标签 (分类)-> 筛选
            Message message = new Message("sun_test_topic","tagA",("Hello RocketMq!" + num).getBytes());
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }
    }
}
