package com.pattern.demo.behavioral.spring.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Order(2)
public class SpringBinaryObserver implements Observer {

	@Getter
	private String binaryRepresentation;
	
	@Autowired
	private ObservableSubject subject;
	
	@Override
	public void update() {
		binaryRepresentation = Integer.toBinaryString(subject.getState());
	}

	
}
