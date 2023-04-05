package com.sulbhacode.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.sulbhacode.ecommerce.entity.Product;
import com.sulbhacode.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		HttpMethod[] theUnsupportedActions= {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		//disable HTTP methods for product: PUT,POST and DELETE
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		//disable HTTP methods ofr productCategory:Put, POST,and DELETE
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpMethods)-> httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions));
	}

	
	
}
