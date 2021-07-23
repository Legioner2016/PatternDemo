package com.pattern.demo.behavioral.core.template;

public class IntArrayWithSum extends ArrayWithSum<Integer> {

	public IntArrayWithSum(Integer[] array) {
		super(array);
	}

	@Override
	protected Integer baseResult() {
		return 0;
	}

	@Override
	protected Integer sum(Integer first, Integer second) {
		return first + second;
	}
	

}
