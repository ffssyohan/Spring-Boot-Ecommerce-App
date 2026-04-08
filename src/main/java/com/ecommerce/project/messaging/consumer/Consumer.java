package com.ecommerce.project.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "test")
    public void receive(String message){
        System.out.println("Received " + message);
    }
}
