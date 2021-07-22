package com.pattern.demo.structural.core.flyweight;

import lombok.Setter;

import lombok.Getter;

@Getter @Setter
public class Matrix {
	
	private int rows;
	private int columns;
	private int[][] matrix;
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new int[rows][columns];
	}
	
	

}

