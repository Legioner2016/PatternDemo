package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.decorator.AddAllCountingList;

@SpringBootTest
public class DecoratorTest {
	
	@Test
	public void testPattern() {
		AddAllCountingList<Integer> list = new AddAllCountingList<>(new ArrayList<>());
		List<Integer> toAdd = IntStream.range(0, 5).boxed().collect(Collectors.toList());
		list.addAll(toAdd);
		list.addAll(toAdd);
		assertEquals(2, list.addAllTimes());
	}

	//Nothing special has being founded
	@Test
	public void testPatternSpring() {
		
	}

}
