package com.pattern.demo.creational.core.object_pool;

import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplayerPool extends ObjectPool<MatrixMultiplierTread> {

	private final AtomicInteger number = new AtomicInteger(0);
	
	private int[][] matrixOne;
	private int[][] matrixTwo;
	private int[][] matrixResult;

	public MatrixMultiplayerPool(int capacity) {
		super(capacity);
	}
	
	public MatrixMultiplayerPool(int capacity, int[][] matrixOne, int[][] matrixTwo, int[][] matrixResult) {
		super(capacity);
		this.matrixOne = matrixOne;
		this.matrixTwo = matrixTwo;
		this.matrixResult = matrixResult;
	}

	@Override
	public MatrixMultiplierTread createObject() {
		MatrixMultiplierTread obj = new MatrixMultiplierTread(matrixOne, matrixTwo, matrixResult, number.incrementAndGet());
		obj.pool(this);
		return obj;
	}
	
	public void release(MatrixMultiplierTread thread) {
		synchronized (locker) {
			objectMap.put(thread, true);
			locker.notify(); 
		}
	}

}
