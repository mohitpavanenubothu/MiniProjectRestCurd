package com.springrest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.apis(RequestHandlerSelectors.basePackage("com.springrest.controller"))
						.paths(PathSelectors.regex("/tourist.*"))
						.build()
						.useDefaultResponseMessages(true)
						.apiInfo(getApiInfo());		
	}
	
	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Satya", "http://www.HCL.com/tourist", "satyamcajava@gmail.com");
		return new ApiInfo("Tourist API",
				"Gives Info Tourist Activities",
				"3.4 RELEASE",
				"http://www.hcl.com/license",
				contact,
				"GNU Public",
				"http://apache.org/license/gnu",
				Collections.emptyList());
	}

}
