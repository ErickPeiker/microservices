package com.nt.scms2.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public void printMessage(String text) {
		System.out.println("MS2: "+text);
	}

}
