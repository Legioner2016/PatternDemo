package com.pattern.demo.creational.spring.object_pool;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ObjectPoolConfig {
	
	@Bean
	@Scope("prototype")
	ObjectToPool objectTarget() {
		return new ObjectToPool(); 
	}
	
	@Bean
	CommonsPool2TargetSource poolTargetSource() {
		CommonsPool2TargetSource bean = new CommonsPool2TargetSource();
		bean.setTargetBeanName("objectTarget");
		bean.setMinIdle(1);
		bean.setMaxSize(2);
		return bean;
	}	

//    @Bean
//    public ProxyFactoryBean proxyFactoryBean() {
//        ProxyFactoryBean p = new ProxyFactoryBean();
//        p.setTargetSource(poolTargetSource());
//        return p;
//    }
	
}

