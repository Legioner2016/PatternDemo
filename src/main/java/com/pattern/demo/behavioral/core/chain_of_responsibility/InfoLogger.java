package com.pattern.demo.behavioral.core.chain_of_responsibility;

public class InfoLogger extends Logger {

	public InfoLogger(int level, Logger nextLogger) {
		super(level, nextLogger);
	}

	@Override
	public void log(Message message) {
		if (message.getLevel() == INFO) {
			messagesProcessed++;
			System.out.println(message.text);
		}
		else {
			nextLogger.log(message);	
		}
	}
	
}
