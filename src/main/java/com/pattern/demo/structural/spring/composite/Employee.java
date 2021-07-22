package com.pattern.demo.structural.spring.composite;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Employee implements FirmEmployee {

	final private Integer id;
	final private String name;
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void add(FirmEmployee emp) {
		throw new IllegalStateException();
	}
	@Override
	public void remove(FirmEmployee emp) {
		throw new IllegalStateException();
	}
	@Override
	public List<FirmEmployee> childs() {
		throw new IllegalStateException();
	}
	@Override
	public String print() {
		return "id: " + id + ", name: " + name;
	}

	
}
