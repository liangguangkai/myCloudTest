package com.lgk.consumer.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dpf
 * @version 1.0
 * @date 2020-6-22 9:52
 * @instruction ...
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 业务交换机
     */
    public static final String DESTINATION_NAME = "rabbitMq_direct";
    /**
     * 业务队列名称
     */
    public static final String SMS_QUEUE = "Sms_msg";
    /**
     * 死信队列交换机名称
     */
    public static final String   DEAD_LETTER_EXCHANGE_NAME="deadLetter_direct";
    /**
     * 死信队列名称
     */
    public static final String   DEAD_LETTER_QUEUE = "deadLetter_queue";
    /**
     * RouteKey
     */
    public static final String SMS_ROUTING_KEY = "sms";
    /**
     * 配置死信交换机
     * @return
     */
    @Bean
    public DirectExchange deadLetterDirectExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE_NAME);
    }
    /**
     * 配置死信队列
     * @return
     */
    @Bean
    public Queue deadLetterQueue(){
        return new Queue(DEAD_LETTER_QUEUE);
    }
    /**
     * 绑定死信队列和死信交换机
     * @return
     */
    @Bean
    Binding deadLetterBindingDirect() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterDirectExchange()).with(SMS_ROUTING_KEY);
    }
    /**
     * 配置队列
     * @return
     */
    @Bean
    public Queue smsDirectQueue() {
        Map<String, Object> args = new HashMap<>(16);
        // 队列消息过期时间
        args.put("x-message-ttl", 10000);
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE_NAME);
        args.put("x-dead-letter-routing-key", SMS_ROUTING_KEY);
        //  args.put("x-expires", 5000);队列过期时间
        // args.put("x-max-length",5 );
        return new Queue(SMS_QUEUE, true,false,false,args);
    }
    /**
     * 配置交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DESTINATION_NAME);
    }

    /**
     * 交换机与队列绑定
     * @return
     */
    @Bean
    Binding smsBindingDirect() {
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with(SMS_ROUTING_KEY);
    }


}