package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.chain_of_responsibility.ErrorLogger;
import com.pattern.demo.behavioral.core.chain_of_responsibility.InfoLogger;
import com.pattern.demo.behavioral.core.chain_of_responsibility.Logger;
import com.pattern.demo.behavioral.core.chain_of_responsibility.Message;
import com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger.LEVEL;

@SpringBootTest
public class ChainOfResponsebilityTest {

	@Autowired
	List<com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger> loggers;

	@Autowired
	@Qualifier("infoLogger")
	com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger infoLogger;

	@Autowired
	@Qualifier("errorLogger")
	com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger errorLogger;
	
	@Test
	public void testPattern() {
		Logger errorLogger = new ErrorLogger(Logger.ERROR, null);
		Logger infoLogger = new InfoLogger(Logger.INFO, errorLogger);
		Logger logger = infoLogger;
		
		Message message1 = new Message(Logger.ERROR, "Error 1");
		logger.log(message1);
		Message message2 = new Message(Logger.ERROR, "Error 2");
		logger.log(message2);
		Message message3 = new Message(Logger.INFO, "Info 1");
		logger.log(message3);
		
		assertEquals(1, infoLogger.getProcessed());
		assertEquals(2, errorLogger.getProcessed());
	}
	
	@Test
	public void testPatternSpring() {
		com.pattern.demo.behavioral.spring.chain_of_responsibility.Message message1 
			= new com.pattern.demo.behavioral.spring.chain_of_responsibility.Message(LEVEL.ERROR, "Error 1");
		com.pattern.demo.behavioral.spring.chain_of_responsibility.Message message2 
			= new com.pattern.demo.behavioral.spring.chain_of_responsibility.Message(LEVEL.ERROR, "Error 2");
		com.pattern.demo.behavioral.spring.chain_of_responsibility.Message message3 
			= new com.pattern.demo.behavioral.spring.chain_of_responsibility.Message(LEVEL.INFO, "Info 1");
		
		loggers.get(0).log(message1);
		loggers.get(0).log(message2);
		loggers.get(0).log(message3);
		
		assertEquals(1, infoLogger.processed());
		assertEquals(2, errorLogger.processed());
		
		
	}
	
	
}
