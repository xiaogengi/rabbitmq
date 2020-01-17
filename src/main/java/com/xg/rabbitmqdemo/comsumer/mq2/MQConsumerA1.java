package com.xg.rabbitmqdemo.comsumer.mq2;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqdemo
 * @description: 消费者
 * @author: gzk
 * @create: 2019-12-27 11:07
 **/
@Component
public class MQConsumerA1 {

    @RabbitListener(queues = "mq.test.demo")
    public void comsumer(Message message) throws Exception {
        String s = new String(message.getBody(), "utf-8");
        System.out.println("mq2 : 消费者2号：" + s.substring(1,s.length()-1));
    }

}
