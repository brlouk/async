package org.brlouk.async.send.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.brlouk.async.send.services.AsyncService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

	@Resource
	private AmqpTemplate amqpTemplate;

	@Value("${async.appid}")
	private String appId;
	
	@Override
	public void sendMessage(String queueName, String objectId) {
		sendMessage(queueName, objectId, new HashMap<>());
	}

	@Override
	public void sendMessage(String queueName, String objectId, Map<String, Object> headers) {
		Message message = MessageBuilder.withBody(objectId.getBytes())
				/* headers */
				.copyHeadersIfAbsent(headers)
				/* APP_ID */
				.setAppId(appId)
				/* BUILD */
				.build();
		convertAndSend(queueName, message);
	}

	private void convertAndSend(String queueName, Message message) {
		amqpTemplate.convertAndSend(queueName, message);
	}

}
