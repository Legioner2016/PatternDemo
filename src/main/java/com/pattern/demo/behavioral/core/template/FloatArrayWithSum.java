package com.pattern.demo.behavioral.core.template;

public class FloatArrayWithSum extends ArrayWithSum<Float> {

	public FloatArrayWithSum(Float[] array) {
		super(array);
	}

	@Override
	protected Float baseResult() {
		return 0f;
	}

	@Override
	protected Float sum(Float first, Float second) {
		return first + second;
	}


}
