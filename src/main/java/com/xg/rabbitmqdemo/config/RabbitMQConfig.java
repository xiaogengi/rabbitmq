package com.xg.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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

    //消息队列
    @Bean
    public Queue Queue(){
        return new Queue("mq_test");
    }


    //消息队列
    @Bean
    public Queue Queue1(){
        return new Queue("mq_test_1");
    }

    //交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_exchange_test");
    }

    //把 mq_test 队列绑定到交换机
    @Bean
    public Binding bindingQueue1ToExchange(){
        return BindingBuilder.bind(Queue()).to(fanoutExchange());
    }

    //把 mq_test_1 队列绑定到交换机
    @Bean
    public Binding bindingQueue2ToExchange(){
        return BindingBuilder.bind(Queue1()).to(fanoutExchange());
    }

    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
