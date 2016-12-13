package org.brlouk.async.send.services;

import java.util.Map;

public interface AsyncService {

	void sendMessage(String queueName, String objectId, Map<String, Object> headers);

	void sendMessage(String queueName, String objectId);

}
