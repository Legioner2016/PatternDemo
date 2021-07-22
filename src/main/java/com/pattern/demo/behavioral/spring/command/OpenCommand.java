package com.pattern.demo.behavioral.spring.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("DocumentOpenCommand")
public class OpenCommand implements DocumentCommand {

	@Autowired
	private Document	doc;

	@Override
	public String execute() {
		return doc.open();
	}
	
	  
	
}
