package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.behavioral.core.command.Broker;
import com.pattern.demo.behavioral.core.command.BuyStockCommand;
import com.pattern.demo.behavioral.core.command.SellStockCommand;
import com.pattern.demo.behavioral.spring.command.DocumentService;
import com.pattern.demo.behavioral.core.command.Stock;

@SpringBootTest
public class CommandTest {
	
	@Autowired
	DocumentService	documentService;

	@Test
	public void testPattern() {
		Stock stock = new Stock();
		BuyStockCommand buyCommand = new BuyStockCommand(stock);
		SellStockCommand sellCommand = new SellStockCommand(stock);
		
		Broker broker = new Broker();
		broker.takeOrder(buyCommand);
		broker.takeOrder(sellCommand);
		
		List<String> test = broker.placeOrders();
		
		assertEquals("buy 10 to First", test.get(0));
		assertEquals("sell 10 from First", test.get(1));
	}
	
	public void testPatternSpring() {
		assertEquals("document has been opened", documentService.doAction("DocumentOpenCommand"));
		assertEquals("document has been saved", documentService.doAction("DocumentSaveCommand"));
	}
	
}
