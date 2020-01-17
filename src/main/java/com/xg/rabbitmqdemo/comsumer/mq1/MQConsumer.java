package com.xg.rabbitmqdemo.comsumer.mq1;

import com.xg.rabbitmqdemo.config.RabbitMQConfig;
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
public class MQConsumer {

    static String mq_test = RabbitMQConfig.MQ_TEST;

    @RabbitListener(queues = "mq.demo")
    public void consumer(Message message) throws Exception {
        String s = new String(message.getBody(), "utf-8");
        System.out.println("mq1 : 消费者1号：" + s.substring(1,s.length()-1));
    }

}
