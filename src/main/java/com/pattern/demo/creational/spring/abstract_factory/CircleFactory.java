package com.pattern.demo.creational.spring.abstract_factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.pattern.demo.creational.core.abstract_factory.Circle;
import com.pattern.demo.creational.core.abstract_factory.Ellipse;
import com.pattern.demo.creational.core.abstract_factory.Shape;

@Component
public class CircleFactory implements FactoryBean<Shape> {

	private String type = "CIRCLE";
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public Shape getObject() throws Exception {
		switch (type) {
			case "CIRCLE": return new Circle(); 
			case "ELLIPSE": return new Ellipse();
		default: return null;
		}
	}

	@Override
	public Class<?> getObjectType() {
		return Shape.class;
	}

	
	
}
