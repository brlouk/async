package org.brlouk.async.send.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * Optional: Auto create Queues
 */
@Configuration
public class RabbitConfiguration {

	@Value("${async.solr.queue}")
	private String solrQueueName;

	@Value("${async.basex.queue}")
	private String basexQueueName;

	@Bean
	public Queue solrQueue() {
		return new Queue(solrQueueName);
	}

	@Bean
	public Queue baseXQueue() {
		return new Queue(basexQueueName);
	}

}
