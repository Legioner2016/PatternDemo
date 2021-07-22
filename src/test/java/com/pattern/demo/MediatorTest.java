package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pattern.demo.behavioral.core.mediator.ArmedUnit;
import com.pattern.demo.behavioral.core.mediator.Commander;
import com.pattern.demo.behavioral.core.mediator.CommanderImpl;
import com.pattern.demo.behavioral.core.mediator.SoldierUnit;
import com.pattern.demo.behavioral.core.mediator.TankUnit;
import com.pattern.demo.behavioral.spring.mediator.SpringCommander;

@SpringBootTest
public class MediatorTest {
	
	@Autowired
	SpringCommander	springCommander;

	@Test
	public void testPattern() {
		Commander commander = new CommanderImpl();
		ArmedUnit soldierUnit = new SoldierUnit();
		ArmedUnit tankUnit = new TankUnit();
		commander.registerArmedUnits(soldierUnit, tankUnit);
		
		assertTrue(commander.startAttack(soldierUnit));
		assertFalse(commander.startAttack(tankUnit));
		assertTrue(commander.stopAttack(soldierUnit));
		assertTrue(commander.startAttack(tankUnit));
	}
	
	@Test
	public void testPatternSpring() {
		assertTrue(springCommander.attackSoldier());
		assertFalse(springCommander.attackTank());
		assertTrue(springCommander.stopAttackSoldier());
		assertTrue(springCommander.attackTank());
	}
	
	
}
