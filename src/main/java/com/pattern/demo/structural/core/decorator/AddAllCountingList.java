package com.pattern.demo.structural.core.decorator;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class AddAllCountingList<E> implements List<E> {
	
	@Delegate(excludes = ExcludesListMethods.class)
	private final List<E> delegate;

	private final AtomicInteger addAllCount = new AtomicInteger();
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addAllCount.incrementAndGet();
		return delegate.addAll(c);
	}
	
	public int addAllTimes() {
		return addAllCount.get();
	}
	
	private abstract class ExcludesListMethods {
		public abstract boolean addAll(Collection<? extends E> c);
	}


}
