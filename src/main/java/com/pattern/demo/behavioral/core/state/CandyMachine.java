package com.pattern.demo.behavioral.core.state;

import lombok.Getter;
import lombok.Setter;

public class CandyMachine {
	@Getter
	NoCoinState noCoinState;
	@Getter
	ContainCoinState containsCoinState;
	@Getter
	DispensedState dispensedState;
	@Getter
	NoCandyState noCandyState;
	@Setter
	CandyMachineState state;
	
	@Setter @Getter
	int count; 
	
	public CandyMachine()  {
		count = 0;
		noCoinState = new NoCoinState(this);
		containsCoinState = new ContainCoinState(this);
		dispensedState = new DispensedState(this);
		noCandyState = new NoCandyState(this);
		state = noCandyState;
	}
	
	public void fillCandy(int count) {
		this.count = count;
		this.state = noCoinState;
	}
	
	public void ejectCandy() {
		state.dispense();
	}
	
	public void insertCoin() {
		state.insertCoin();
	}

	public void pressButton() {
		state.pressButton();
	}
	
	@Override
	public String toString() {
		return "Current candy machine state is " + state.stateName() + ". Candies available = " + count;
	}
	
}
