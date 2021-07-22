package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.flyweight.MartixFactory;
import com.pattern.demo.structural.core.flyweight.Matrix;

/**
 * Don't understand what kind of benefits it is have.
 * With garbage collector there is no needed to change objects state instead of create new (
 * only if we want to reduce garbage collector work)
 * 
 * @author legioner
 *
 */
@SpringBootTest
public class FlyweightTest {

	@Test
	public void testPattern() {
		Matrix matrix1 = MartixFactory.getMatrix(3, 3);
		Matrix matrix2 = MartixFactory.getMatrix(3, 3);
		assertTrue(matrix1 == matrix2);
		Matrix matrix3 = MartixFactory.getMatrix(4, 5);
		assertFalse(matrix1 == matrix3);
		Matrix matrix4 = MartixFactory.getMatrix(4, 6);
		assertFalse(matrix3 == matrix4);
		Matrix matrix5 = MartixFactory.getMatrix(4, 5);
		assertTrue(matrix3 == matrix5);
	}
	
	//Nothing special
	@Test
	public void testPatternSpring() {
		
	}
	
}
