package com.pattern.demo.structural.core.facade;

public class ShapeMaker {
	final private Shape circle = new Circle();
	final private Shape rectangle = new Rectangle();
	
	public String drawCircle() {
		return circle.draw();
	}	

	public String drawRectangle() {
		return rectangle.draw();
	}	
	
}
