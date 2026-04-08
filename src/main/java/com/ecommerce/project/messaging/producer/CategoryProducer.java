package com.ecommerce.project.messaging.producer;

import com.ecommerce.project.payload.CategoryDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryProducer {

    private final RabbitTemplate rabbitTemplate;

    public CategoryProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendCreatedCategory(CategoryDTO categoryDTO){
        try {
        rabbitTemplate.convertAndSend("category.queue", categoryDTO.getCategoryName());
        } catch (Exception e) {
            System.out.println("Error at sending message: " + e.getMessage());
        }
    }
}
