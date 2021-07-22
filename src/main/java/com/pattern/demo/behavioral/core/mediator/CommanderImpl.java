package com.pattern.demo.behavioral.core.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommanderImpl implements Commander {

	private List<ArmedUnit> units = new ArrayList<>();
	private boolean  attackStatus = false; 
	
	@Override
	public void registerArmedUnits(ArmedUnit... armedUnits) {
		units.addAll(Stream.of(armedUnits).collect(Collectors.toList()));
		units.forEach(u -> u.setCommander(this));
	}

	@Override
	public void setAttackStatus(boolean attackStatus) {
		this.attackStatus = attackStatus;
	}
	
	@Override
	public boolean canAttack() {
		return !attackStatus;
	}
	
	@Override
	public boolean startAttack(ArmedUnit unit) {
		return  unit.attack();
	}

	@Override
	public boolean stopAttack(ArmedUnit unit) {
		return  unit.stopAttack();
	}

}
