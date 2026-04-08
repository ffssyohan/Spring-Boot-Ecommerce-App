package com.ecommerce.project.controller;

import com.ecommerce.project.config.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MessagingController {

    private final Producer producer;

    public MessagingController(Producer producer){
        this.producer = producer;
    }

    @GetMapping
    public String send() {
        producer.send("hello rabbitmq \uD83D\uDE80");
        return "Message sent!";
    }

}
