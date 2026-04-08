package com.ecommerce.project.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CategoryConsumer {

    @RabbitListener(queues = "category.queue")

    public void consume(String message){
        System.out.println("New category created: " + message);
    }

}
