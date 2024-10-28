package com.springmvcproject.productmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Product Management System")
                .version("1.0")
                .description("API for managing products")
                .termsOfService("http://localhost:8080/terms")
                .contact(new Contact()
                        .name("Ahmad Tommalieh")
                        .url("http://localhost:8080/contact")
                        .email("ahmadtommaliehh@gmail.com"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}
