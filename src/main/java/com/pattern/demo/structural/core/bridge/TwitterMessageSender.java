package com.pattern.demo.structural.core.bridge;

public class TwitterMessageSender implements MessageSender {

	@Override
	public String sendMessage(String text) {
		return "message sent by twitter: " + text;
	}
	

}
