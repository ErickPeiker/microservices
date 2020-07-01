package com.nt.scms2.consumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.scms2.exchanges.HelloExchange;
import com.nt.scms2.services.HelloService;

@Component
public class HelloConsumer {
	
	@Autowired
	private HelloService helloService;
	
	@RabbitListener(queues = HelloExchange.QUEUE)
    public void consumer(Message message) {
		System.out.println("ms2 receive: "+message);
        helloService.printMessage(new String(message.getBody()));
    }

}
