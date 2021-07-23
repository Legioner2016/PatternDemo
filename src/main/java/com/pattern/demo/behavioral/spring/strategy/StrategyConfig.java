package com.pattern.demo.behavioral.spring.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pattern.demo.behavioral.core.strategy.Strategy;

@Configuration
public class StrategyConfig {

	@Bean("addStrategy")
	public SpringStrategy addStrategy() {
		return new SpringStrategy() {
			
			@Override
			public int calculate(int first, int second) {
				return first + second;
			}
		};
	}

	@Bean("multStrategy")
	public SpringStrategy multStrategy() {
		return new SpringStrategy() {
			
			@Override
			public int calculate(int first, int second) {
				return first * second;
			}
		};
	}
	
	
	
}
