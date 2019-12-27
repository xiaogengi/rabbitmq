package com.xg.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description: 配置类
 * @author: gzk
 * @create: 2019-12-27 11:15
 **/
@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue Queue(){
        return new Queue("mq_test");
    }

    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
