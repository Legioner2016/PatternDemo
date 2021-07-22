package com.pattern.demo.creational.spring.object_pool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ObjectToPool {
	
	private String name;
	
	public ObjectToPool() {
		System.out.println("object to pool created");
	}

}
