package com.pattern.demo.behavioral.core.template;

public abstract class ArrayWithSum<T extends Number> {
	protected T[] array;
	
	public ArrayWithSum(T[] array) {
		this.array = array;
	}
	
	public T getSum() {
		T result = baseResult();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				result = sum(result, array[i]);
			}
		}
		return result;
	}

	protected abstract T baseResult();  
	protected abstract T sum(T first, T second);
	
}
