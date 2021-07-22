package com.pattern.demo.behavioral.spring.chain_of_responsibility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LoggerImpl implements Logger {

	private int processed = 0;
	final private LEVEL level;
	
	private List<Logger> loggers;
	
	@Override
	public int processed() {
		return processed;
	}

	@Override
	public void log(Message message) {
		if (message.getLevel() == level) {
			processed++;
			log.info(message.getText());
		}
		else {
			loggers.stream().filter(l -> l.getLevel().getLevel() > this.level.getLevel())
								.findFirst().get().log(message);
		}
	}

	@Override
	public LEVEL getLevel() {
		return level;
	}
	
	@Autowired
	public void setLoggers(List<Logger> loggers) {
		this.loggers = loggers;
	}

}
