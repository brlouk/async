package org.brlouk.async.send;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.brlouk.async.send.services.AsyncSolrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncSolrServiceTest {

	@Resource
	private AsyncSolrService asyncSolrService;

	@Test
	public void doSolrTest() {
		asyncSolrService.doSolrIndex("123");
	}

	@Test
	public void doSolrTest2() {
		Map<String, Object> headers = new HashMap<>();
		headers.put("h1", 123L);
		asyncSolrService.doSolrIndex("456", headers);
	}

}
