package com.example.demoSpringBoot.MyJMSj.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
 
@Configuration

public class Config {
	
	public String brokerURL="tcp://localhost:61616";
	
	public String user="admin";
	
	public String pass="admin";
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("publisher.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		factory.setUserName(user);
		factory.setPassword(pass);
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}

}
