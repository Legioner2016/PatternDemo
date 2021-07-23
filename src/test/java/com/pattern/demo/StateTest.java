package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;

import com.pattern.demo.behavioral.core.state.CandyMachine;
import com.pattern.demo.behavioral.spring.state.CandyMachineConfig.ListenerWithCount;
import com.pattern.demo.behavioral.spring.state.Events;
import com.pattern.demo.behavioral.spring.state.States;

@SpringBootTest
public class StateTest {
	
	@Autowired
	StateMachine<States, Events> stateMachine;
	
	@Autowired
	ListenerWithCount listener;
	
	@Test
	public void testPattern() {
		CandyMachine machine = new CandyMachine();
		machine.fillCandy(3);
		machine.insertCoin();
		machine.pressButton();
		machine.ejectCandy();
		
		assertEquals(2, machine.getCount());
		
		machine.insertCoin();
		machine.pressButton();
		machine.ejectCandy();

		machine.insertCoin();
		machine.pressButton();
		machine.ejectCandy();

		assertThrows(IllegalStateException.class, () -> machine.insertCoin());
		
		machine.fillCandy(1);
		machine.insertCoin();
		
		assertEquals("Current candy machine state is Contains coin state. Candies available = 1", machine.toString());
		
	}

	@Test
	public void testPatternSpring() { 
		stateMachine.sendEvent(Events.INSERT_COIN);
		stateMachine.sendEvent(Events.PRESS_BUTTON);
		stateMachine.sendEvent(Events.EJECT_CANDY);
		
		stateMachine.sendEvent(Events.INSERT_COIN);
		stateMachine.sendEvent(Events.PRESS_BUTTON);
		stateMachine.sendEvent(Events.EJECT_CANDY);

		assertEquals(8, listener.getCount());
		
	}
	
}
