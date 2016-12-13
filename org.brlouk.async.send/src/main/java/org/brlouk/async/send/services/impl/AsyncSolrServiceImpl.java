package org.brlouk.async.send.services.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.brlouk.async.send.services.AsyncService;
import org.brlouk.async.send.services.AsyncSolrService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AsyncSolrServiceImpl implements AsyncSolrService {

	@Resource
	private AsyncService asyncService;

	@Value("${async.solr.queue}")
	private String solrQueueName;

	@Override
	public void doSolrIndex(String objectId) {
		asyncService.sendMessage(solrQueueName, objectId);
	}

	@Override
	public void doSolrIndex(String objectId, Map<String, Object> headers) {
		asyncService.sendMessage(solrQueueName, objectId, headers);
	}

}
