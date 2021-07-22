package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.observer.BinaryObserver;
import com.pattern.demo.behavioral.core.observer.HexObserver;
import com.pattern.demo.behavioral.core.observer.Subject;
import com.pattern.demo.behavioral.spring.observer.ObservableSubject;
import com.pattern.demo.behavioral.spring.observer.Observer;
import com.pattern.demo.behavioral.spring.observer.SpringBinaryObserver;
import com.pattern.demo.behavioral.spring.observer.SpringHexObserver;

@SpringBootTest
public class ObserverTest {

	@Autowired
	ObservableSubject subject;

	@Autowired
	List<Observer> observers;
	
	@Test
	public void testPattern() {
		Subject subject = new Subject();
		BinaryObserver bObserver = new BinaryObserver(subject);
		HexObserver hObserver = new HexObserver(subject);
		
		subject.setState(15);
		
		assertEquals("f", hObserver.getHexRepresentation());
		assertEquals("1111", bObserver.getBinaryRepresentation());
		
		subject.setState(23);
		
		assertEquals("17", hObserver.getHexRepresentation());
		assertEquals("10111", bObserver.getBinaryRepresentation());
		
	}

	@Test
	public void testPatternSpring() {
		subject.setState(15);
		
		assertEquals("f", ((SpringHexObserver)observers.get(0)).getHexRepresentation());
		assertEquals("1111", ((SpringBinaryObserver)observers.get(1)).getBinaryRepresentation());
		
	}

	
}
