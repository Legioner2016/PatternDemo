package com.pattern.demo.behavioral.core.iterator;

public class IteratorsNamesCollection implements Iterable<String> {
	
	private static final String[] names = {"First name", "Second name", "Third name", "Fourth name"};

	@Override
	public Iterator<String> getIterator() {
		return new IteratorsNamesCollection.Iterator_();
	}
	
	private class Iterator_ implements Iterator<String> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < names.length;
		}

		@Override
		public String next() {
			return names[index++];
		}
		
	}

	
	

}
