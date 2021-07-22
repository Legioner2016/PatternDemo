package com.pattern.demo.behavioral.spring.chain_of_responsibility;

import com.pattern.demo.behavioral.spring.chain_of_responsibility.Logger.LEVEL;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class Message {
	final LEVEL level;
	final String text;
}
