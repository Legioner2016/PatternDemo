package com.pattern.demo.behavioral.core.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class Message {
	final int level;
	final String text;
}
