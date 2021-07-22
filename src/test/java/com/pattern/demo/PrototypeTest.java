package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.creational.core.prototype.Prototype;

@SpringBootTest
public class PrototypeTest {
	
	@Test
	public void testPattern() throws CloneNotSupportedException {
		Prototype proto = new Prototype("first");
		Prototype proto2 = proto.clone("second");
		assertFalse(proto == proto2);
		assertEquals("first", proto.getName());
		assertEquals("second", proto2.getName());
	}

	//Nothing similar in spring
	@Test
	public void testPatternSpring() {
		
	}

	
}
