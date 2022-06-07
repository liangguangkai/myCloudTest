package com.lgk.producerb.controller;

import com.lgk.producerb.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mq")
public class MQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

//    @GetMapping("/add/{Priority}")
//    public void testSimpleQueue(@PathVariable(value = "Priority") Integer priority) {
//        //队列名称
//        String queueName = RabbitmqConfig.QUEUE;
//        //要发送的消息
//        String msg = "I want to fuck ! "+priority;
//        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setPriority(10);
//                return message;
////                这里可以配置优先级
//            }
//        };
//        System.out.println(queueName);
//        rabbitTemplate.convertAndSend("",queueName, msg, messagePostProcessor, null);
//    }

    @GetMapping("/addDelayMessage/{name}")
    public void testSimpleQueue(@PathVariable(value = "name") String name) {
        //队列名称
        String RouteKey = RabbitmqConfig.SMS_ROUTING_KEY;
        //要发送的消息
        String msg = "I want to fuck ! "+name;

        System.out.println(RouteKey);
        rabbitTemplate.convertAndSend(RabbitmqConfig.DESTINATION_NAME, RouteKey, msg);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.SMS_QUEUE, msg);
    }
}
