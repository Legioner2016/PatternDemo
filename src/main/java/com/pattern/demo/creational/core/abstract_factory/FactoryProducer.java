package com.pattern.demo.creational.core.abstract_factory;

public class FactoryProducer {

	public static AbstractFactory getFactory(boolean circle) {
		if (circle) {
			return new CircleFactory();
		}
		return new PoligonFactory(); 
	}
	
}
