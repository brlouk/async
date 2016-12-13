package org.brlouk.async.receiver.handlers;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class BaseXMessageHandler implements MessageHandler {

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		throw new IllegalArgumentException();
	}

}
