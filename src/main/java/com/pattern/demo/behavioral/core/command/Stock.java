package com.pattern.demo.behavioral.core.command;

public class Stock {

	private String name = "First";
	private int quantity = 10;
	
	public String buy() {
		return "buy " + quantity + " to " + name;
	}

	public String sell() {
		return "sell " + quantity + " from " + name;
	}

	
}
