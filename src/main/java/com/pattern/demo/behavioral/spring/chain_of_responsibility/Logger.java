package com.pattern.demo.behavioral.spring.chain_of_responsibility;

import lombok.Getter;

public interface Logger {
	
	@Getter
	public static enum LEVEL {
		INFO(1),
		ERROR(2);
		
		private int level;
		
		private LEVEL(int level) {
			this.level = level;
		}
	}

	int processed();
	void log(Message message);
	LEVEL getLevel();
	
}
