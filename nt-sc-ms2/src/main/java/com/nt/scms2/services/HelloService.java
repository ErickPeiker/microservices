package com.nt.scms2.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public void printMessage(String text) {
		System.out.println(LocalDateTime.now()+" : "+text);
	}

}
