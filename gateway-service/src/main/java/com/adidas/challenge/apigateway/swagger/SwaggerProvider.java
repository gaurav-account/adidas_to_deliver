package com.adidas.challenge.apigateway.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger Resource Implementation class.
 * @author Gaurav Kumar
 *
 */
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

	/* 
	 * Returns the resource for airline-business-service
	 * (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("airline-business-service", "/airlines/v2/api-docs", "2.0"));
        return resources;
    }
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
		// Creating SwaggerResource Object & setting name, location and version.
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
