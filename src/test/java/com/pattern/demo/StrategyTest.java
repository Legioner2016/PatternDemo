package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.strategy.AddStrategy;
import com.pattern.demo.behavioral.core.strategy.Context;
import com.pattern.demo.behavioral.core.strategy.MultiplyStrategy;
import com.pattern.demo.behavioral.spring.strategy.StrategyContext;
import com.pattern.demo.behavioral.spring.strategy.StrategyEnum;

@SpringBootTest
public class StrategyTest {

	@Autowired
	StrategyContext		context;
	
	@Test
	public void testPattern() {
		Context context = new Context();
		context.setStrategy(new AddStrategy());
		
		assertEquals(5, context.executeStrategy(2, 3));
		
		context.setStrategy(new MultiplyStrategy());
		
		assertEquals(6, context.executeStrategy(2, 3));
		
	}
	
	@Test
	public void testPatternSpring() {
		context.setCurrentStrategy(StrategyEnum.ADD);
		
		assertEquals(5, context.executeStrategy(2, 3));

		context.setCurrentStrategy(StrategyEnum.MULT);
		
		assertEquals(6, context.executeStrategy(2, 3));
		
	} 
	
}
