package com.pattern.demo.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testmvc")
public class Controller {

	@SuppressWarnings("serial")
	private static final List<Model> modelCollection = new ArrayList<Model>() {
		{
			add(new Model(1, "first"));
			add(new Model(2, "second"));
		}
	};
	
	@GetMapping(path = "/byid", produces = MediaType.APPLICATION_JSON_VALUE)
	public View getViewById(@RequestParam Integer id) {
		return modelCollection.stream().filter(m -> id.equals(m.getId()))
				.map(m -> new View(m.getName())).findFirst().orElse(null);
	} 
	
}
