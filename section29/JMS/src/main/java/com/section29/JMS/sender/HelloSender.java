package com.section29.JMS.sender;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.section29.JMS.config.JmsConfig;
import com.section29.JMS.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloSender {

	private final JmsTemplate jmsTemplate;
	private final ObjectMapper objectMapper;

	@Scheduled(fixedRate = 2000)
	public void sendMessage() {
		HelloWorldMessage message = HelloWorldMessage.builder()
				.id(UUID.randomUUID())
				.message("Hello world!")
				.build();

		jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

	}

	@Scheduled(fixedRate = 2000)
	public void sendAndReceiveMessage() throws JMSException {
		HelloWorldMessage message = HelloWorldMessage.builder()
				.id(UUID.randomUUID())
				.message("Hello world!")
				.build();

		Message receviedMsg = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RVC_QUEUE, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				Message helloMessage = null;
				try {
					helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
					helloMessage.setStringProperty("_type", "com.section29.JMS.model.HelloWorldMessage");

					System.out.println("Sending Hello");

					return helloMessage;
				} catch(JsonProcessingException e) {
					throw new JMSException("boom");
				}
			}
		});

		System.out.println(receviedMsg.getBody(String.class));

	}
}
