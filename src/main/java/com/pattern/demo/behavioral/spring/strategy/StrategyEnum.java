package com.pattern.demo.behavioral.spring.strategy;

import lombok.Getter;

public enum StrategyEnum {
	MULT("multStrategy"),
	ADD("addStrategy");
	
	@Getter
	private String strategy;
	
	private StrategyEnum(String strategy) {
		this.strategy = strategy;
	}
}
