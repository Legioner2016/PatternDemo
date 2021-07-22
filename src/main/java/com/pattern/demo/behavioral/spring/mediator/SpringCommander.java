package com.pattern.demo.behavioral.spring.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class SpringCommander {

	@Getter @Setter
	private boolean attack = false;
	
	private BattleUnit currentSoldier;
	private BattleUnit currentTank;
	
	@Autowired
	private Soldier soldier;

	@Autowired
	private Tank tank;
	
	public boolean attackSoldier() {
		currentSoldier = soldier;
		return currentSoldier.attack(); 
	}
	
	public boolean stopAttackSoldier() {
		return currentSoldier.stopAttack();
	}

	public boolean attackTank() {
		currentTank = tank;
		return currentTank.attack(); 
	}
	
	public boolean stopAttackTank() {
		return currentTank.stopAttack();
	}

	
}
