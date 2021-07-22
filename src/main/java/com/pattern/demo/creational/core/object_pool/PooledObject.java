package com.pattern.demo.creational.core.object_pool;

public interface PooledObject {
	
	<T extends PooledObject> void pool(ObjectPool<T> pool);
	void release();

}
