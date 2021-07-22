package com.pattern.demo.behavioral.spring.chain_of_responsibility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger.LEVEL;

@Configuration
public class ChainConfig {
	
	@Bean(name = "infoLogger")
	@Order(1)
	public Logger getInfoLogger() {
		LoggerImpl infoLogger = new LoggerImpl(LEVEL.INFO);
		return infoLogger;
	}

	@Bean(name = "errorLogger")
	@Order(2)
	public Logger getErrorLogger() {
		LoggerImpl errorLogger = new LoggerImpl(LEVEL.ERROR);
		return errorLogger;
	}

	
}
