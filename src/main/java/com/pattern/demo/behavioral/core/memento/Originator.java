package com.pattern.demo.behavioral.core.memento;

import lombok.Setter;

import lombok.Getter;

public class Originator {
	@Getter @Setter
	private String state;
	
	public Memento saveStateToMemento() {
		return new Memento(state);
	}
	
	public void getStetFromMemento(Memento memento) {
		state = memento.getState();
	}
	
}
