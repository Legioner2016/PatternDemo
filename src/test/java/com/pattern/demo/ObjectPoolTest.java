package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pattern.demo.creational.core.object_pool.MatrixMultiplayerPool;
import com.pattern.demo.creational.core.object_pool.MatrixMultiplierTread;
import com.pattern.demo.creational.spring.object_pool.ObjectToPool;

import lombok.SneakyThrows;

@SpringBootTest
public class ObjectPoolTest {
	
	@Autowired
	CommonsPool2TargetSource poolTargetSource;
	
	@SneakyThrows
	@Test
	public void testPattern() {
		int[][] matrixOne = {
				{0,1,2,3},
				{4,5,6,7},
				{8,9,10,11},
				{12,13,14,15}
		};
		int[][] matrixTwo = {
				{16,17,18,19},
				{20,21,22,23},
				{24,25,26,27},
				{28,29,30,31}
		};
		int[][] matrixResult = {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		MatrixMultiplayerPool pool = new MatrixMultiplayerPool(4, matrixOne, matrixTwo, matrixResult);
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < matrixOne.length; i++) {
			for (int j = 0; j < matrixOne[0].length; j++) {
				MatrixMultiplierTread thread = pool.get();
				thread.setElement(j, i);
				service.execute(thread);
			}
		} 
		
		service.shutdown();
		
		Thread.currentThread().sleep(3000L);
		
		assertEquals(1370, matrixResult[3][3]);
	}

	@Test
	public void testPatternSpring() throws Exception {
		ObjectToPool obj1 =  (ObjectToPool)poolTargetSource.getTarget();
		ObjectToPool obj2 =  (ObjectToPool)poolTargetSource.getTarget();
		
		assertNotNull(obj1);
		assertNotNull(obj2);

		assertFalse(obj1 == obj2);
		poolTargetSource.releaseTarget(obj1);
		ObjectToPool obj3 =  (ObjectToPool)poolTargetSource.getTarget();
		
		assertNotNull(obj3);
		
		assertTrue(obj1 == obj3);
	}


}
