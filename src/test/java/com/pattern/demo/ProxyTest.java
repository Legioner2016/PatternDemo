package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.proxy.BaseInterface;
import com.pattern.demo.structural.core.proxy.BaseInterfaceImpl;
import com.pattern.demo.structural.core.proxy.MyInvocationHandler;
import com.pattern.demo.structural.spring.proxy.ProxedBean;
import com.pattern.demo.structural.spring.proxy.ProxyBean;

@SpringBootTest
public class ProxyTest {
	
	@Autowired
	ProxyBean		proxy;

	@Autowired
	ProxedBean		bean;

	
	@Test
	public void testPattern() {
		BaseInterface proxyInstance = (BaseInterface) Proxy.newProxyInstance(
				BaseInterface.class.getClassLoader(), 
				  new Class[] { BaseInterface.class }, 
				  new MyInvocationHandler(new BaseInterfaceImpl()));
		assertEquals("test", proxyInstance.getText());
	}

	@Test
	public void testPatternSpring() {
		assertEquals("test", bean.getText());
		assertEquals(1, proxy.getCallsCount());
		assertEquals("test", bean.getText());
		assertEquals(2, proxy.getCallsCount());
	}

	
}
