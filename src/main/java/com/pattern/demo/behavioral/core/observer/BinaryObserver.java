package com.pattern.demo.behavioral.core.observer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryObserver extends Observer {

	@Getter
	private String binaryRepresentation;
	
	public BinaryObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		binaryRepresentation = Integer.toBinaryString(((Subject)subject).getState()); 
		log.info(binaryRepresentation);
	}

}
