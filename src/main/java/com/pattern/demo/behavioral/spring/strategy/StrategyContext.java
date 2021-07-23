package com.pattern.demo.behavioral.spring.strategy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class StrategyContext {

	@Autowired
	Map<String, SpringStrategy> strategies;
	
	@Setter
	StrategyEnum currentStrategy;
	
	public int executeStrategy(int first, int second) {
		return strategies.get(currentStrategy.getStrategy()).calculate(first, second);
	}
	
}
