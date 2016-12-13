package org.brlouk.async.send.services;

import java.util.Map;

public interface AsyncSolrService {

	void doSolrIndex(String objectId, Map<String, Object> headers);

	void doSolrIndex(String objectId);

}
