package com.pattern.demo.creational.core.singleton;

public class EagerSingleton {

	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton() {}
	
	public static EagerSingleton getInstance() {
		return instance;
	} 
	
}
