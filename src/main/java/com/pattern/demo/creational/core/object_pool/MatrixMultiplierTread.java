package com.pattern.demo.creational.core.object_pool;

import lombok.SneakyThrows;

public class MatrixMultiplierTread implements Runnable, PooledObject {
	
	private int column;
	private int row;
	private int[][] matrixOne;
	private int[][] matrixTwo;
	private int[][] matrixResult;
	
	private MatrixMultiplayerPool pool;
	
	private int num;
	
	public MatrixMultiplierTread(int[][] matrixOne, int[][] matrixTwo, int[][] matrixResult, int num) {
		if (matrixOne == null || matrixTwo == null || matrixResult == null) throw new IllegalArgumentException();
		if (matrixOne.length == 0 || matrixOne[0].length != matrixTwo.length) throw new IllegalArgumentException();
		this.num = num;
		this.matrixOne = matrixOne;
		this.matrixTwo = matrixTwo;
		this.matrixResult = matrixResult;
	}
	
	public void setElement(int column, int row) {
		this.row = row;
		this.column = column;
	}

	@SneakyThrows
	@Override
	public void run() {
		Thread.currentThread().sleep(500L);
		int result = 0;
		for (int i = 0; i < matrixOne[0].length; i++) {
			result += matrixOne[row][i] * matrixTwo[i][column];
		}
		matrixResult[row][column] = result;
		System.out.println("Element " + row + ", " + column + " calculated with thread " + num);
		release();
	}

	@Override
	public void pool(ObjectPool pool) {
		this.pool = (MatrixMultiplayerPool) pool; 
	}

	@Override
	public void release() {
		pool.release(this);
	}
	
}
