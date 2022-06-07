package com.lgk.consumer.mqListener;

import com.lgk.consumer.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    @RabbitListener(queues = RabbitmqConfig.DEAD_LETTER_QUEUE)
    public void consumeDelayMessage(String msg){
        System.out.println("delay :" + msg);
    }

}
