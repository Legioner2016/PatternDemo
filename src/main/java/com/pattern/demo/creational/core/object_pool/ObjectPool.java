package com.pattern.demo.creational.core.object_pool;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public abstract class ObjectPool<T> {
	
	protected Map<T, Boolean> objectMap = new ConcurrentHashMap<T, Boolean>();
	
	protected final int maxSize;
	
	protected Object locker = new Object();
	
	@SneakyThrows
	public T get() {
		T result = null;
		synchronized (locker) {
			while (result == null) {
				Optional<T> freeFirst = objectMap.entrySet().stream()
						.filter(e -> Boolean.TRUE.equals(e.getValue())).map(Entry::getKey).findFirst();
				if (freeFirst.isPresent()) {
					result = freeFirst.get(); 
				}
				else {
					if (maxSize > objectMap.size()) {
						T newObj = createObject();
						objectMap.put(newObj, true);
						result = newObj; 
					}
				}
				if (result != null) {
					objectMap.put(result, false);
				}
				else {
					locker.wait();
				}
			}
		}
		return result;
	}

	public abstract void release(T object);
	
	public abstract T createObject();
	
}
