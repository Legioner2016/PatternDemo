package com.pattern.demo.creational.spring.abstract_factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.pattern.demo.creational.core.abstract_factory.Pentagon;
import com.pattern.demo.creational.core.abstract_factory.Polygon;
import com.pattern.demo.creational.core.abstract_factory.Rectangle;

@Component
public class PolygonFactory  implements FactoryBean<Polygon> {

	private String type = "Rectangle";
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public Polygon getObject() throws Exception {
		switch (type) {
			case "Rectangle": return new Rectangle(); 
			case "Pentagon": return new Pentagon();
		default: return null;
		}
	}

	@Override
	public Class<?> getObjectType() {
		return Polygon.class;
	}

	
	
}
