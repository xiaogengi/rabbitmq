package com.xg.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class RabbitmqdemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            //topic_exchange_test 是交换机的key
            CorrelationData correlationData = new CorrelationData((new Date().getTime() +i) + "");
            rabbitTemplate.convertAndSend("topic_exchange_test","com.xg","我是" + i,correlationData);
        }
    }

}
