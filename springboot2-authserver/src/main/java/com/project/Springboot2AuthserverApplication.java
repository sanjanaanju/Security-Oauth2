package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@EnableSwagger2
public class Springboot2AuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2AuthserverApplication.class, args);
	}
	
	@Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("app.yichi"))
                .build()
                .apiInfo(apiDetails());
        
    }

	 @SuppressWarnings("deprecation")
	    private ApiInfo apiDetails() {
	        // TODO Auto-generated method stub
	        return new ApiInfo("YICHI API", null, null, null, null, null, null);
	    }
}
