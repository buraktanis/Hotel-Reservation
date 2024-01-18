package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition
@SpringBootApplication
public class RoomsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomsApplication.class, args);
    }

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI().info(new Info().title("BookStore API").version("1.0"));
    }
}