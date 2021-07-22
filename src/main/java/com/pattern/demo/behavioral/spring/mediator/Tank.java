package com.pattern.demo.behavioral.spring.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Tank implements BattleUnit {

	@Autowired
	SpringCommander	springCommander;
	
	@Value("#{springCommander.attack}")
	boolean attackInProgress;

	@Override
	public boolean canAttack() {
		return !attackInProgress;
	}

	@Override
	public boolean attack() {
		if (canAttack()) {
			springCommander.setAttack(true);
			return true;
		}
		return false;
	}

	@Override
	public boolean stopAttack() {
		springCommander.setAttack(false);
		return true;
	}

	
}
