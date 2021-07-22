package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.iterator.Iterator;
import com.pattern.demo.behavioral.core.iterator.IteratorsNamesCollection;

@SpringBootTest
public class IteratorTest {
	
	//Of course iterator already exists in Java, but i use "homemade"
	@Test
	public void testPattern() {
		IteratorsNamesCollection iterable = new IteratorsNamesCollection();
		Iterator<String> iterator = iterable.getIterator();
		StringBuilder test = new StringBuilder();
		while (iterator.hasNext()) {
			test.append(iterator.next()).append(",");
		}
		test.setLength(test.length() - 1);
		assertEquals("First name,Second name,Third name,Fourth name", test.toString());		
	}

	//Nothing special
	@Test
	public void testPatternSpring() {
		
	}

}
