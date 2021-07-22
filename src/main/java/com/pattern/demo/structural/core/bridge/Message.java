package com.pattern.demo.structural.core.bridge;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Message {
	final protected MessageSender messageSender;
	final protected String text;

	abstract public String send();
	
}
