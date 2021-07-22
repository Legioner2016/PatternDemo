package com.pattern.demo.behavioral.core.command;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Broker {
	
	private List<Command> orders = new ArrayList<>();
	
	public void takeOrder(Command command) {
		orders.add(command);
	}
	
	public List<String> placeOrders() {
		List<String> result = orders.stream().map(Command::execute).collect(Collectors.toList());
		orders.clear();
		return result;
	}

}
