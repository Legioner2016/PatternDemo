package com.pattern.demo.structural.core.bridge;

public class EmailMessageSender implements MessageSender {

	@Override
	public String sendMessage(String text) {
		return "message sent by email: " + text;
	}

}
