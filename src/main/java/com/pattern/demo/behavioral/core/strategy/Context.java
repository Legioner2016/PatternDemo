package com.pattern.demo.behavioral.core.strategy;

import lombok.Setter;

public class Context {

	@Setter
	Strategy strategy;
	
	public int executeStrategy(int first, int second) {
		return strategy.calculate(first, second);
	}
}
