package com.pattern.demo.creational.core.prototype;

public class Prototype implements Cloneable {
	
	private String name;
	
	public Prototype(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Prototype clone(String newName) throws CloneNotSupportedException {
		Prototype clone = (Prototype)super.clone();
		clone.setName(newName);
		return clone;
	}

}
