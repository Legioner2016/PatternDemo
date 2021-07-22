package com.pattern.demo.behavioral.core.observer;

public interface Observable {
	void attach(Observer observer);
	void notifyAllObservers();
}
