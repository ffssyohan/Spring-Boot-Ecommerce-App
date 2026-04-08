package com.ecommerce.project.messaging.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message){
        rabbitTemplate.convertAndSend("test", message);
    }

}
