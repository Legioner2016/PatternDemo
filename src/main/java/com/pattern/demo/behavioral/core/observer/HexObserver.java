package com.pattern.demo.behavioral.core.observer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HexObserver extends Observer {

	@Getter
	private String hexRepresentation;
	
	public HexObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		hexRepresentation = Integer.toHexString(((Subject)subject).getState()); 
		log.info(hexRepresentation);
	}

}
