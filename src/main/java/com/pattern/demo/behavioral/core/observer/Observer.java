package com.pattern.demo.behavioral.core.observer;

public abstract class Observer {
	protected Observable subject;
	public abstract void update();
	
	public Observer(Observable subject) {
		this.subject = subject;
		subject.attach(this);
	}
}
