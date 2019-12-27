package com.xg.rabbitmqdemo.comsumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.security.util.Length;

import java.io.UnsupportedEncodingException;

/**
 * @program: rabbitmqdemo
 * @description: 消费者
 * @author: gzk
 * @create: 2019-12-27 11:07
 **/
@Component
public class MQComsumer {

    @RabbitListener(queues = "mq_test")
    public void comsumer(Message message) throws Exception {
        String s = new String(message.getBody(), "utf-8");
        System.out.println(s.substring(1,s.length()-1));
    }

}
