package com.sofka.demo.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "transactionsQueue")
    public void consumeMessage(String message) {
        // Procesar el mensaje
        System.out.println("Mensaje recibido: " + message);
    }
}