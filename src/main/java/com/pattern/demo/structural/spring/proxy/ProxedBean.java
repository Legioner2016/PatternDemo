package com.pattern.demo.structural.spring.proxy;

import org.springframework.stereotype.Component;

@Component
public class ProxedBean {
	
	@ProxyAnnnotation
	public String getText() {
		return "test";
	}

}
