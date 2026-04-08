package com.ecommerce.project.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "test")
    public void receive(String message){
        System.out.println("Received " + message);
    }
}
