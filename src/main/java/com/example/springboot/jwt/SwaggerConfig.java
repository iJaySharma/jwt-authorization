package com.example.springboot.jwt;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Parameter;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	 @Bean
	  public Docket api() {
	    // @formatter:off
	    //Register the controllers to swagger
	    //Also it is configuring the Swagger Docket
	    return new Docket(DocumentationType.SWAGGER_2).select()
	        // .apis(RequestHandlerSelectors.any())
	        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	        // .paths(PathSelectors.any())
	        // .paths(PathSelectors.ant("/swagger2-demo"))
	        .build().globalOperationParameters(operationParameters());
	    // @formatter:on
	  }
	 
	 


		private List<Parameter> operationParameters() {
		List<Parameter> headers = new ArrayList<>();
		headers.add(new ParameterBuilder().name("Authorization")
		    .description("Bearer <authToken>")
		    .modelRef(new ModelRef("string")).parameterType("header")
		    .required(false).build());
		
		return headers;
		}
	 
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) 
	  {
	    //enabling swagger-ui part for visual documentation
	    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }

}