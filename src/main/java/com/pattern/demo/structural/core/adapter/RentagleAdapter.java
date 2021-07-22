package com.pattern.demo.structural.core.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RentagleAdapter implements Shape {

	private final Rentagle rect;

	@Override
	public String draw() {
		return rect.drawRentagle();
	}
	
	
	
}
