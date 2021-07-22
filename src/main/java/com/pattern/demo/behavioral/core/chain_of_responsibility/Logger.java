package com.pattern.demo.behavioral.core.chain_of_responsibility;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Logger {
	public static final int ERROR = 1;
	public static final int INFO = 2;

	final protected int level;
	final protected Logger nextLogger;
	protected int messagesProcessed = 0;
	
	public abstract void log(Message message);
	
	public int getProcessed() {
		return  messagesProcessed;
	}
	
}
