package com.xg.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqdemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            //fanout_exchange_test 是交换机的key
            rabbitTemplate.convertAndSend("fanout_exchange_test","mq_test_1","我是" + i);
        }
    }

}
