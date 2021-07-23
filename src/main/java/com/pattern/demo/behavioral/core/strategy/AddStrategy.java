package com.pattern.demo.behavioral.core.strategy;

public class AddStrategy implements Strategy {

	@Override
	public int calculate(int first, int second) {
		return first + second;
	}

}
