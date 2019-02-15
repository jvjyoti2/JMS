package com.example.demoSpringBoot.MyJMSj.listener;

import java.util.Base64;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demoSpringBoot.MyJMSj.resource.ProducerResource;

@Component
public class Consumer {
	
	@JmsListener(destination = "publisher.queue")
	public void listener(String message) {
		System.out.println("Recieved Message: "+message);
		String decodedString = new String(Base64.getDecoder().decode(message));
		System.out.println(decodedString);
		if(ProducerResource.originalMsg.equals(decodedString))
		{
			System.out.println("Input text and Output text are same.");
		}
		else
		{
			System.out.println("Input text and Output text are different.");
		}
		
		
	}
 
}
