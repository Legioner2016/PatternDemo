package com.pattern.demo.behavioral.core.mediator;

public interface Commander {
	void registerArmedUnits(ArmedUnit... units);
	void setAttackStatus(boolean attackStatus);
	boolean startAttack(ArmedUnit unit);
	boolean stopAttack(ArmedUnit unit);
	boolean canAttack();

}
