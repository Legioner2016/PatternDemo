package com.pattern.demo.creational.core.singleton;


public class LazySingleton {

	private static volatile LazySingleton instance = null; 
	private static volatile int inicializationCount = 0;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstnce() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
					inicializationCount++;
				}
			}
		}
		return instance;
	}
	
	public int initTimes() {
		return inicializationCount;
	}
	
}
