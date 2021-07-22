package com.pattern.demo.behavioral.core.chain_of_responsibility;

public class ErrorLogger extends Logger {

	public ErrorLogger(int level, Logger nextLogger) {
		super(level, nextLogger);
	}

	@Override
	public void log(Message message) {
		if (message.getLevel() == ERROR) {
			messagesProcessed++;
			System.out.println(message.getText());
		}
		else {
			nextLogger.log(message);
		}
	}
	
	

}
