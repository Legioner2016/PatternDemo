package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.adapter.RentagleAdapter;
import com.pattern.demo.structural.core.adapter.RentagleImpl;

@SpringBootTest
public class AdapterTest {

	@Test
	public void testPattern() {
		RentagleImpl rect = new RentagleImpl();
		assertEquals("rectangle", rect.drawRentagle());
		RentagleAdapter adapter = new RentagleAdapter(rect);
		assertEquals("rectangle", adapter.draw());
	}
	
	//Nothing special for spring
	@Test
	public void testPatternSpring() {
		
	}
	
	
}
