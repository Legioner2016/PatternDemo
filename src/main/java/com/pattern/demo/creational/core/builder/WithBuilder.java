package com.pattern.demo.creational.core.builder;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class WithBuilder {
	
	private Integer id;
	private String name;
	@Default
	private String gender = "m";

}
