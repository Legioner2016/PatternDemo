package com.pattern.demo.behavioral.core.state;

public interface CandyMachineState {
	void insertCoin();
	void pressButton();
	void dispense();
	String stateName();

}
