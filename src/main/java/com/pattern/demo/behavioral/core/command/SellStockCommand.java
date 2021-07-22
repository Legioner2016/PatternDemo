package com.pattern.demo.behavioral.core.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SellStockCommand implements Command {
	private final Stock stock;

	@Override
	public String execute() {
		return stock.sell();
	}

	
}
