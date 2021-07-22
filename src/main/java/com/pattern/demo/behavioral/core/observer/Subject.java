package com.pattern.demo.behavioral.core.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Observable {
	
	private List<Observer> observeres = new ArrayList<>();
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	@Override
	public void attach(Observer observer) {
		observeres.add(observer);
	}

	@Override
	public void notifyAllObservers() {
		observeres.forEach(Observer::update);
	}

	
}
