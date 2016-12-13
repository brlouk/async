package org.brlouk.async.receiver.config;

import javax.annotation.Resource;

import org.brlouk.async.receiver.handlers.BaseXMessageHandler;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;

@Configuration
public class RabbitConfiguration {
	
	@Resource
	private BaseXMessageHandler baseXMessageHandler;

	@Bean
	public IntegrationFlow amqpInbound(ConnectionFactory connectionFactory) {
		return IntegrationFlows.from(Amqp.inboundAdapter(connectionFactory, "basex.queue"))
				.handle(baseXMessageHandler).get();
	}
	
	

}
