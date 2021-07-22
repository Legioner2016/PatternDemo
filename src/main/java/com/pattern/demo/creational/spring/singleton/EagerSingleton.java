package com.pattern.demo.creational.spring.singleton;

import org.springframework.stereotype.Component;

@Component
public class EagerSingleton {

	public EagerSingleton() {
		System.out.println("Eager singleton initiliazed");
	}
	
}
