package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.creational.core.builder.WithBuilder;

@SpringBootTest
public class BuilderTest {
	
	@Autowired
	WithBuilder withBuilder;

	@Test
	public void testPattern() {
		WithBuilder obj = WithBuilder.builder().id(1).name("1").build();
		WithBuilder obj2 = WithBuilder.builder().id(2).name("2").gender("f").build();
		
		assertEquals("m", obj.getGender());
		assertEquals("f", obj2.getGender());
	}

	@Test
	public void testPatternSpring() {
		assertEquals("m", withBuilder.getGender());
		assertEquals("test", withBuilder.getName());
	}

	
}
