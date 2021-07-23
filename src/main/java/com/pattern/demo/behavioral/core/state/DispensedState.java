package com.pattern.demo.behavioral.core.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DispensedState implements CandyMachineState {
	
	final CandyMachine machine;

	@Override
	public void insertCoin() {
		throw new IllegalStateException("System is already dispensing");
	}

	@Override
	public void pressButton() {
		throw new IllegalStateException("System is currently dispensing");
	}

	@Override
	public void dispense() {
		machine.setCount(machine.getCount() - 1);
		if (machine.getCount() > 0) {
			machine.setState(machine.getNoCoinState());
		}
		else {
			machine.setState(machine.getNoCandyState());
		}
	}

	@Override
	public String stateName() {
		return "Dispense state";
	}
	

}
