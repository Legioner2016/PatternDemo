package com.pattern.demo.creational.spring.singleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazySingleton {
	
	public LazySingleton() {
		System.out.println("Lazy singleton initiliazed");
	}
	
	private int a = 1;
	
	
	public int getA() {return a;}

}
