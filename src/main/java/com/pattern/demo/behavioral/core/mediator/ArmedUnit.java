package com.pattern.demo.behavioral.core.mediator;

public interface ArmedUnit {
	boolean attack();
	boolean stopAttack();
	void setCommander(Commander commander);
}
