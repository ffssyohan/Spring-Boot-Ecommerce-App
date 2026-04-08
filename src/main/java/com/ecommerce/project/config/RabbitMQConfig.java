package com.ecommerce.project.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("test", true);
    }
}
