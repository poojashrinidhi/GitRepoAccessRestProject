package com.remind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author PoojaShankar
 */
@SpringBootApplication
public class RemindMeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemindMeProjectApplication.class, args);
	}

	@Bean
	public RestTemplate constructRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
