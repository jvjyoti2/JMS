package com.example.demoSpringBoot.MyJMSj.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
 
@Configuration
@ComponentScan

public class Config {
	
	@Value("${activemq.broker-url}")
	private String brokerURL;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("publisher.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.getBrokerURL();
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}

}
