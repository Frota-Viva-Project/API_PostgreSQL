package org.example.frotavivapostgreapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta da autenticação com token JWT")
public class AuthResponseDTO {
    
    @Schema(description = "Token JWT para autenticação", 
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;
    
    @Schema(description = "Tipo do token", 
            example = "Bearer", 
            defaultValue = "Bearer")
    private String tokenType = "Bearer";
    
    @Schema(description = "Tempo de expiração do token em milissegundos", 
            example = "86400000")
    private Long expiresIn;

    public AuthResponseDTO(String token, Long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}