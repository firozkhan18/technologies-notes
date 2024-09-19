package com.springboot.microservice.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

//    @Bean
//    public GroupedOpenApi employeeApi() {
//        return GroupedOpenApi.builder()
//                .group("employees")
//                .pathsToMatch("/employees/**") // Adjust as necessary
//                .packagesToScan("com.springboot.microservice.controller") // Specify the package to scan
//                .build();
//    }
//    
//    @Bean
//    public GroupedOpenApi webClientApi() {
//        return GroupedOpenApi.builder()
//                .group("api-v1")
//                .pathsToMatch("/api/v1**") // Adjust as necessary
//                .packagesToScan("com.springboot.microservice.controller") // Specify the package to scan
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi restClientApi() {
//        return GroupedOpenApi.builder()
//                .group("api-v2")
//                .pathsToMatch("/api/v2**") // Adjust as necessary
//                .packagesToScan("com.springboot.microservice.controller") // Specify the package to scan
//                .build();
//    }
//    
    @Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("controller-api")
                .packagesToScan("com.springboot.microservice.rest") // Specify the package to scan
                .build();
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Inter-communication API")
                        .description(
                        "This project implemented with Spring Boot and Java 17.")
                        .contact(new Contact().name("Firoz Khan Developer").url("https://github.com/firozkhan18")));
    }
}
