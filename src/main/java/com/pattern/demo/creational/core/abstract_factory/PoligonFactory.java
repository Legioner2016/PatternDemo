package com.pattern.demo.creational.core.abstract_factory;

public class PoligonFactory implements AbstractFactory {

	@Override
	public Polygon getShape(String shapeType) {
		switch (shapeType) {
		case "Rectangle": return new Rectangle(); 
		case "Pentagon": return new Pentagon();
		default: return null;
		}
	}

}
