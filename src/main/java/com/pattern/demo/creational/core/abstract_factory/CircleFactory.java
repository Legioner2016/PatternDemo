package com.pattern.demo.creational.core.abstract_factory;

public class CircleFactory implements AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		switch (shapeType) {
		case "CIRCLE": return new Circle(); 
		case "ELLIPSE": return new Ellipse();
		default: return null;
		}
	}

}
