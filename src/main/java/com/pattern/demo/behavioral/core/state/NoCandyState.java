package com.pattern.demo.behavioral.core.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoCandyState implements CandyMachineState {

	final CandyMachine machine;

	@Override
	public void insertCoin() {
		throw new IllegalStateException("No candies availbale");
	}

	@Override
	public void pressButton() {
		throw new IllegalStateException("No candies availbale");
	}

	@Override
	public void dispense() {
		throw new IllegalStateException("No candies availbale");
	}

	@Override
	public String stateName() {
		return "No candy state";
	}
	
	
}
