package com.pattern.demo.behavioral.core.interpreter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContainExpression implements Expression {
	final private String data;

	@Override
	public boolean interpret(String context) {
		return context.toLowerCase().contains(data.toLowerCase());
	}
	
}
