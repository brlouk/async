package org.brlouk.async.send.services;

import java.util.Map;

public interface AsyncBaseXService {

	void pushToBaseX(String objectId);

	void pushToBaseX(String objectId, Map<String, Object> headers);


}
