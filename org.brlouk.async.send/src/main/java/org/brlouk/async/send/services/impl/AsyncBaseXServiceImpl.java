package org.brlouk.async.send.services.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.brlouk.async.send.services.AsyncBaseXService;
import org.brlouk.async.send.services.AsyncService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AsyncBaseXServiceImpl implements AsyncBaseXService {

	@Resource
	private AsyncService asyncService;

	@Value("${async.basex.queue}")
	private String basexQueueName;

	@Override
	public void pushToBaseX(String objectId) {
		asyncService.sendMessage(basexQueueName, objectId);
	}

	@Override
	public void pushToBaseX(String objectId, Map<String, Object> headers) {
		asyncService.sendMessage(basexQueueName, objectId, headers);
	}

}
