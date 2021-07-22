package com.pattern.demo.structural.core.bridge;

public class TwitterMessage extends Message {
	
	public TwitterMessage(MessageSender sender, String text) {
		super(sender, text);
	}
	
	@Override
	public String send() {
		return messageSender.sendMessage(text);
	}


}
