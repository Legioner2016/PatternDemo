package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;

import com.pattern.demo.creational.core.singleton.EagerSingleton;
import com.pattern.demo.creational.core.singleton.LazySingleton;

@SpringBootTest
public class SingletonTest implements ApplicationContextAware {

	ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	@Autowired
	com.pattern.demo.creational.spring.singleton.EagerSingleton singleton1;

	@Autowired
	@Lazy
	com.pattern.demo.creational.spring.singleton.LazySingleton singletonLazy;
	
	@Test
	public void testPattern() {
		EagerSingleton singleton = EagerSingleton.getInstance();
		EagerSingleton singleton2 = EagerSingleton.getInstance();
		assertTrue(singleton == singleton2);
		
		LazySingleton lazy1 = LazySingleton.getInstnce();
		LazySingleton lazy2 = LazySingleton.getInstnce();
		LazySingleton lazy3 = LazySingleton.getInstnce();
		
		assertTrue(lazy1 == lazy2);
		assertEquals(1, lazy3.initTimes());
	}

	@Test
	public void testPatternSpring() {
		com.pattern.demo.creational.spring.singleton.EagerSingleton singleton2 = 
				context.getBean(com.pattern.demo.creational.spring.singleton.EagerSingleton.class);
		assertTrue(singleton1 == singleton2);
		//singletonLazy.getA();	
	}

	
}
