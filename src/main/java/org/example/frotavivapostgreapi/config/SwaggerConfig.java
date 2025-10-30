package org.example.frotavivapostgreapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Frota Viva")
                        .version("v1.0.0")
                        .description("API completa para gerenciamento de frota de caminhões com monitoramento em tempo real, " +
                                   "alertas automáticos, manutenções programadas e notificações push. " +
                                   "Inclui integração com sensores Arduino e Firebase para autenticação e notificações."))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor Local")))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token JWT obtido através do endpoint de autenticação")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}