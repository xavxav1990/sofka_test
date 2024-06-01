package com.sofka.demo.services;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String EXCHANGE = "";  // default exchange
    private static final String ROUTING_KEY = "transactionsQueue";

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, message);
    }
}
