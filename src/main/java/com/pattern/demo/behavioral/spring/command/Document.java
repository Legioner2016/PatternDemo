package com.pattern.demo.behavioral.spring.command;

import org.springframework.stereotype.Component;

@Component
public class Document {

	public String open() {
		return "document has been opened";
	}

	public String save() {
		return "document has been saved";
	}

	
}
