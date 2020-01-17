package com.xg.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
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
    public Queue Queue1(){ return new Queue("mq.test.demo"); }

    //交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_exchange_test");
    }

    //把 mq_test_1 队列绑定到交换机
    @Bean
    public Binding bindingQueue2ToExchange(){
        //匹配 routingKey为 mq.test.demo.r   或者 mq.test.demo.s  mq.test.demo. 后可以跟任意一个单词
        return BindingBuilder.bind(Queue1()).to(topicExchange()).with("com.xg");
    }


    public static final String MQ_TEST = "mq.demo";

    public static final String MQ_TEST_DEMO = "mq.test.demo";

    //消息队列
    @Bean
    public Queue Queue(){
        return new Queue(this.MQ_TEST);
    }

//    @Bean
//    public Binding bindingQueue3ToExchange(){
//        //匹配 routingKey为 mq.test.demo.r   或者 mq.test.demo.s  mq.test.demo. 后可以跟任意一个单词
//        return BindingBuilder.bind(Queue1()).to(topicExchange()).with("mq.test.demo.#");
//    }




    //把 mq_test 队列绑定到交换机
    @Bean
    public Binding bindingQueue1ToExchange(){
        return BindingBuilder.bind(Queue()).to(topicExchange()).with(this.MQ_TEST + ".#");
    }







    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
