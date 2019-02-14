package com.example.demoSpringBoot.MyJMSj.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination = "publisher.queue")
	public void listener(String message) {
		System.out.println("Recieved Message: "+message);
	}

}
