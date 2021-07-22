package com.pattern.demo.structural.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyInvocationHandler implements InvocationHandler {

	final private Object target;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoked method: " + method.getName());
		return method.invoke(target, args);
	}

}
