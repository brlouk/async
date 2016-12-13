package org.brlouk.async.send;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.brlouk.async.send.services.AsyncBaseXService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncBaseXServiceTest {

	@Resource
	private AsyncBaseXService asyncService;

	@Test
	public void pushToBaseX1() {
		asyncService.pushToBaseX("123");
	}

	@Test
	public void pushToBaseX2() {
		Map<String, Object> headers = new HashMap<>();
		headers.put("h1", 123L);
		asyncService.pushToBaseX("456", headers);
	}

}
