package com.pattern.demo.structural.spring.composite;

import java.util.List;

public interface FirmEmployee {
	Integer getId();
	String getName();
	void add(FirmEmployee emp);
	void remove(FirmEmployee emp); 
	List<FirmEmployee> childs();
	String print();
}
