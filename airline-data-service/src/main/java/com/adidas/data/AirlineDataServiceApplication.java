package com.adidas.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class for Airline Data Service.
 * @author Gaurav Kumar
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class AirlineDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineDataServiceApplication.class, args);
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
		        .description("This service expose all flights data")
		       .build();
	}

}
