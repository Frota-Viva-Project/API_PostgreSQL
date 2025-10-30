package org.example.frotavivapostgreapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Dados para autenticação do usuário")
public class AuthRequestDTO {
    
    @Schema(description = "Nome de usuário ou email", 
            example = "motorista@empresa.com", 
            required = true)
    private String username;
    
    @Schema(description = "Senha do usuário", 
            example = "senha123", 
            required = true)
    private String password;
}