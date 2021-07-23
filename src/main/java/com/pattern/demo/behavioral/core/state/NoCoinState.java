package com.pattern.demo.behavioral.core.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoCoinState implements CandyMachineState {

	final CandyMachine machine;
	
	@Override
	public void insertCoin() {
		machine.setState(machine.getContainsCoinState());
	}

	@Override
	public void pressButton() {
		throw new IllegalStateException("No coin inserted");
	}

	@Override
	public void dispense() {
		throw new IllegalStateException("No coin inserted");
	}

	@Override
	public String stateName() {
		return "No coin state";
	}


}
