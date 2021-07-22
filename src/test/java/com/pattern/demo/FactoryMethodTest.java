package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.creational.core.factory_method.Agreement;
import com.pattern.demo.creational.core.factory_method.Contract;
import com.pattern.demo.creational.core.factory_method.Document;
import com.pattern.demo.creational.core.factory_method.GetDocumentFactory;
import com.pattern.demo.creational.spring.factory_method.FactoryForFactoryMethod;

@SpringBootTest
public class FactoryMethodTest {

	@Autowired
	FactoryForFactoryMethod	factory;

	@Autowired
	Document document;
	
	@Test
	public void testPattern() {
		Document agreement = GetDocumentFactory.getNewDocument();
		GetDocumentFactory.setType(GetDocumentFactory.DocumentType.CONTRACT);
		Document contract = GetDocumentFactory.getNewDocument();
		
		assertEquals(agreement.getClass(), Agreement.class);
		assertEquals(contract.getClass(), Contract.class);
	}

	@Test
	public void testPatternSpring() {
		assertNotNull(document);
	}

	
}
