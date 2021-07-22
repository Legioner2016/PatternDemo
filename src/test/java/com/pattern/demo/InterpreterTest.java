package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.interpreter.AndExpression;
import com.pattern.demo.behavioral.core.interpreter.ContainExpression;
import com.pattern.demo.behavioral.core.interpreter.Expression;
import com.pattern.demo.behavioral.core.interpreter.OrExpression;

@SpringBootTest
public class InterpreterTest {

	@Value("#{${value1} + ${value2}}")
	Integer		interpreteredValue;
	
	@Test
	public void testPattern() {
		Expression robert = new ContainExpression("Robert");
		Expression john = new ContainExpression("John");
		Expression johnOrRobert = new OrExpression(robert, john);
		Expression julie = new ContainExpression("Julie");
		Expression married = new ContainExpression("Married");
		Expression marriedJulie = new AndExpression(julie, married);
		
		assertTrue(johnOrRobert.interpret("John"));
		assertFalse(johnOrRobert.interpret("Roger"));
		assertTrue(marriedJulie.interpret("married Julie"));
	} 

	//Its not exactly interpreter pattern as is, but show that spring use this pattern as well
	@Test
	public void testPatternSpring() {
		assertEquals(9, interpreteredValue);
	} 

	
}
