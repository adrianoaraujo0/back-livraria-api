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
        		.addServersItem(new Server().url("https://back-livraria-api-production.up.railway.app"))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}
