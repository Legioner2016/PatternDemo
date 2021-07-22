package com.pattern.demo.behavioral.spring.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Order(1)
public class SpringHexObserver implements Observer  {

	@Getter
	private String hexRepresentation;
	
	@Autowired
	private ObservableSubject subject;
	
	@Override
	public void update() {
		hexRepresentation = Integer.toHexString(subject.getState());
	}

}
