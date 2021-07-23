package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.pattern.demo.spring.web.mvc.View;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class MvcTest {
	
	 
    @TestConfiguration
    static class MyTestConfiguration implements WebMvcConfigurer {

    	@Bean
    	public RestTemplate restTemplate() {
    		return new RestTemplate();
    	} 
    	
        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
            messageConverters.add(converter);
            restTemplate().setMessageConverters(messageConverters); 
        }
        

    }
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	public void testPatternSpring() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<View> response = null;
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("http").host("127.0.0.1:8080").path("/testmvc/byid").query("id={id}").build();
		assertEquals("http://127.0.0.1:8080/testmvc/byid?id=1", uriComponents.expand(1).toUriString());
		response = restTemplate.exchange(uriComponents.expand(1).toUriString(), HttpMethod.GET, entity, View.class);
		View view = response.getBody();
		assertEquals("first", view.getName());
		
		response = restTemplate.getForEntity(uriComponents.expand(3).toUriString(), View.class);
		view = response.getBody();
		assertNull(view);
	}

	
	
}
