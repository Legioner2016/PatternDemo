package com.pattern.demo.behavioral.spring.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

	@Autowired
	Map<String, DocumentCommand> commandsMap;
	
	public String doAction(String action) {
		return commandsMap.get(action).execute();
	}
	
}
