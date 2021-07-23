package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.template.FloatArrayWithSum;
import com.pattern.demo.behavioral.core.template.IntArrayWithSum;

@SpringBootTest
public class TemplateTest {
	
	@Test
	public void testPattern() {
		IntArrayWithSum arrayInt = new IntArrayWithSum(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		assertEquals(55, arrayInt.getSum());
		FloatArrayWithSum arrayFloat = new FloatArrayWithSum(new Float[]{0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f});
		assertEquals(45f, arrayFloat.getSum(), 0.1f);
	}
	
	//Nothing special
	@Test
	public void testPatternSpring() {
		
	}

}
