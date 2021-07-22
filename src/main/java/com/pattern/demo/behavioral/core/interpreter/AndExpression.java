package com.pattern.demo.behavioral.core.interpreter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AndExpression implements Expression {
	final private Expression first;
	final private Expression second;
	
	@Override
	public boolean interpret(String context) {
		return first.interpret(context) && second.interpret(context);
	}
	
}
