package com.example.demoSpringBoot.MyJMSj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MyJmSjApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(MyJmSjApplication.class, args);
	}
	
}

