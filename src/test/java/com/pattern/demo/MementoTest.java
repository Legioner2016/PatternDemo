package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.memento.CareTaker;
import com.pattern.demo.behavioral.core.memento.Originator;

@SpringBootTest
public class MementoTest {

	@Test
	public void testPattern() {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());
		
		originator.setState("State #4");
		assertEquals("State #4", originator.getState());
		
		originator.getStetFromMemento(careTaker.get(1));
		assertEquals("State #3", originator.getState());
		
	}

	//Haven't found any special implementations for spring
	@Test
	public void testPatternSpring() {
		
	}

	
}
