package com.nt.scms1.exchanges;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloExchange {
	
	public static final String EXCHANGE_NAME = "Textos";
	public static final String ROUTING_KEY = "text-router";

    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder
        		.directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

}
