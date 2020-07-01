package com.nt.scms1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.scms1.services.HelloService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nt-ms1")
public class SimpleController {
	
	@Autowired
	private HelloService helloService;

	@GetMapping(value = "/send-data/{text}")
	public Mono<String> getData(ServerHttpRequest request, ServerHttpResponse response, @PathVariable("text") String text) {
		helloService.sendTextToRabbit(text);
		Mono<String> data = Mono.just("Hello from Reactive SC-MS1 getData method!!");
		return data;
	}
}