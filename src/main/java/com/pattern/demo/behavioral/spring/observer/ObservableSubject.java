package com.pattern.demo.behavioral.spring.observer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class ObservableSubject {
	
	@Getter 
	int state;

	@Autowired
	List<Observer> observers;
	
	public void setState(int state) {
		this.state = state;
		observers.forEach(Observer::update);			
	}
	
	
}
