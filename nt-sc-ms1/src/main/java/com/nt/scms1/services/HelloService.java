package com.nt.scms1.services;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.scms1.exchanges.HelloExchange;

@Service
public class HelloService {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTextToRabbit(String text) {
    	System.out.println(LocalDateTime.now() +" : "+ text);
    	rabbitTemplate.convertAndSend(HelloExchange.EXCHANGE_NAME, HelloExchange.ROUTING_KEY, text);
    }
	
}
