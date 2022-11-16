package com.section29.JMS.listener;

import java.util.UUID;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.section29.JMS.config.JmsConfig;
import com.section29.JMS.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloMessageListener {

	private final JmsTemplate jmsTemplate;

	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage,@Headers MessageHeaders headers, Message message) {
//		System.out.println("I got a Message!!!!!");
//		System.out.println(helloWorldMessage);
	}

	@JmsListener(destination = JmsConfig.MY_SEND_RVC_QUEUE)
	public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,@Headers MessageHeaders headers, Message message) throws JMSException {
//		System.out.println("I got a Message!!!!!");
//		System.out.println(helloWorldMessage);
		HelloWorldMessage payloadMsg = HelloWorldMessage.builder()
				.id(UUID.randomUUID())
				.message("Hello world!")
				.build();

		jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
	}
}
