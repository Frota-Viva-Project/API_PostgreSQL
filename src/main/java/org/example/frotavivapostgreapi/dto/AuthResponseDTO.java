package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
    private String token;
    private String tokenType = "Bearer";
    private Long expiresIn;

    public AuthResponseDTO(String token, Long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}