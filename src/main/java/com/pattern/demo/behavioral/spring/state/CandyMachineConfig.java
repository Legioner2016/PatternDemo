package com.pattern.demo.behavioral.spring.state;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import lombok.Getter;

@Configuration
@EnableStateMachine
public class CandyMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

	@Override
	public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
		config
			.withConfiguration()
			.autoStartup(true)
			.listener(listener());
	}
	
	@Override
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states.withStates().initial(States.NO_COIN_STATE).states(EnumSet.allOf(States.class));
	}
	
	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		transitions
			.withExternal()
				.source(States.NO_COIN_STATE).target(States.INSERTED_COIN_STATE).event(Events.INSERT_COIN)
				.and()
			.withExternal()
				.source(States.INSERTED_COIN_STATE).target(States.DISPENSING).event(Events.PRESS_BUTTON)
				.and()
			.withExternal()
				.source(States.DISPENSING).target(States.NO_COIN_STATE).event(Events.EJECT_CANDY);
				
	}
	
	
	@Bean
	public ListenerWithCount listener() {
		return new ListenerWithCount();
	}
	
	public static class ListenerWithCount extends StateMachineListenerAdapter<States, Events> {
		@Getter
		int count = 10;

		@Override
		public void stateChanged(State<States, Events> from, State<States, Events> to) {
			if (to.getId() == States.DISPENSING) count--;
		}
		
	}  
	
}
