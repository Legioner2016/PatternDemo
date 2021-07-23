package com.pattern.demo;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootTest
public class FrontControllerTest {

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

	
	
}
