package com.pattern.demo.behavioral.core.strategy;

public class MultiplyStrategy implements Strategy {

	@Override
	public int calculate(int first, int second) {
		return first * second;
	}

}
