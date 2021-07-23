package com.pattern.demo.behavioral.core.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContainCoinState implements CandyMachineState {
	
	final CandyMachine machine;

	@Override
	public void insertCoin() {
		throw new IllegalStateException("Coin already inserted");
	}

	@Override
	public void pressButton() {
		machine.setState(machine.getDispensedState());		
	}

	@Override
	public void dispense() {
		throw new IllegalStateException("Press button to dispense");
	}

	@Override
	public String stateName() {
		return "Contains coin state";
	}

	
	
}
