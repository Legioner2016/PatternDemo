package com.pattern.demo.structural.spring.proxy;

import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProxyBean {
	
	private final AtomicInteger countCalls = new AtomicInteger();

	@Before("@annotation(com.pattern.demo.structural.spring.proxy.ProxyAnnnotation)")
	public void proxyMethod(JoinPoint joinPoint) {
		countCalls.incrementAndGet();
	}
	
	public int getCallsCount() {
		return countCalls.get();
	}

	
}
