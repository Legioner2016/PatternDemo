package com.pattern.demo.creational.spring.factory_method;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.pattern.demo.creational.core.factory_method.Document;
import com.pattern.demo.creational.core.factory_method.GetDocumentFactory;

@Component
public class FactoryForFactoryMethod implements FactoryBean<Document> {

	@Override
	public Document getObject() throws Exception {
		return GetDocumentFactory.getNewDocument();
	}

	@Override
	public Class<?> getObjectType() {
		return Document.class;
	}

	
	
}
