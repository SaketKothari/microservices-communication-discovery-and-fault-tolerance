package io.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	// Spring is going to execute this method whatever you've written
	// RestTemplate maps to this one instance, so anybody auto wires RestTemplate
	// they're going to get these instance
	@Bean
	public RestTemplate getRestTemplate() {
		// RestTemplate is the utility object which makes this call
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}

