package com.livraria.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        		.addServersItem(new Server().url("http://api.minhalivraria.com"))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}
