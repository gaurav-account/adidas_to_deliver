package com.adidas.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main Class for Airline Business Service
 * @author Gaurav Kumar
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableSwagger2
public class AirlineBusinessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineBusinessServiceApplication.class, args);
	}

	
	/**
	 * @return RestTemplate
	 */
	@Bean
    @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	 /**
	  * Method for swagger.
	 * @return Docket
	 */
	@Bean
	 public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	                .paths(PathSelectors.any())
	                .build();
	    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
		        .description("This service returns the path given an origin city will return a list of itineraries , one based in the less number of connections and the second based in the less time. ")
		       .build();

	}
}
