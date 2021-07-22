package com.pattern.demo.structural.core.bridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage extends Message {
	
	private String	from;
	private String	to;
	
	public EmailMessage(MessageSender sender, String text) {
		super(sender, text);
	}
	
	@Override
	public String send() {
		return messageSender.sendMessage(prepareMessage());
	}

	private String prepareMessage() {
		return "from: " + from + " to: " + to + "\n" + text;
	}

}
