package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.pattern.demo.creational.core.abstract_factory.AbstractFactory;
import com.pattern.demo.creational.core.abstract_factory.FactoryProducer;
import com.pattern.demo.creational.core.abstract_factory.Shape;
import com.pattern.demo.creational.spring.abstract_factory.CircleFactory;

@SpringBootTest
public class AbstractFactoryTest implements ApplicationContextAware {

	ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	@Test
	public void testPattern() {
		AbstractFactory factory = FactoryProducer.getFactory(true);
		Shape circle = factory.getShape("CIRCLE");
		
		assertEquals("circle", circle.draw());

		AbstractFactory factory2 = FactoryProducer.getFactory(false);
		Shape pentagon = factory2.getShape("Pentagon");
		
		assertEquals("pentagon", pentagon.draw());
		
	}

	//I have not found a "direct" example of this pattern in spring.
	//I think get factory bean from context may be kind of decision 
	@Test
	public void testPatternSpring() throws Exception {
		String factoryBeanName = "circleFactory";
		CircleFactory factory = (CircleFactory) context.getBean("&" + factoryBeanName);
		factory.setType("ELLIPSE");
		Shape ellipse = factory.getObject();
		assertEquals("ellipse", ellipse.draw());
	}

	

}
