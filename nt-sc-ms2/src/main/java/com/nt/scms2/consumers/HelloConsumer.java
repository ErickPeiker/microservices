package com.nt.scms2.consumers;

import java.time.LocalDateTime;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.scms2.exchanges.HelloExchange;
import com.nt.scms2.services.HelloService;
import com.nt.scms2.services.SpeechService;

@Component
public class HelloConsumer {
	
	@Autowired
	private SpeechService speechService;
	
	@Autowired
	private HelloService helloService;
	
	@RabbitListener(queues = HelloExchange.QUEUE)
    public void consumer(Message message) {
		try {
			String textSend = new String(message.getBody());
			System.out.println(LocalDateTime.now()+" Listener : "+textSend);
			helloService.printMessage(textSend);
			speechService.sayIt(textSend);
			helloService.printMessage(textSend);			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
