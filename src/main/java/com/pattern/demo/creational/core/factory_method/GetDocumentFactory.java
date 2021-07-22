package com.pattern.demo.creational.core.factory_method;

public class GetDocumentFactory {
	
	public enum DocumentType {
		AGREEMENT,
		CONTRACT
	}
	
	private static DocumentType type = DocumentType.AGREEMENT;

	public static void setType(DocumentType setType) {
		type = setType;
	}

	public static Document getNewDocument() {
		if (type == DocumentType.AGREEMENT) {
			return new Agreement();	
		}
		return new Contract();
	}	
	

}
