package com.xg.rabbitmqdemo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqdemo
 * @description: 生产者
 * @author: gzk
 * @create: 2019-12-27 11:04
 **/
@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;



    @RequestMapping("test")
    public void test(){
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("mq_test","我是" + i);
        }
    }





}
