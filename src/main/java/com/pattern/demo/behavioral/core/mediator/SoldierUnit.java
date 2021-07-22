package com.pattern.demo.behavioral.core.mediator;

public class SoldierUnit implements ArmedUnit {

	private Commander	commander;
	
	@Override
	public boolean attack() {
		if (commander.canAttack()) {
			commander.setAttackStatus(true);
			return true;
		} 
		return false;
	}

	@Override
	public boolean stopAttack() {
		commander.setAttackStatus(false);
		return true;
	}

	@Override
	public void setCommander(Commander commander) {
		this.commander = commander;
	}

}
