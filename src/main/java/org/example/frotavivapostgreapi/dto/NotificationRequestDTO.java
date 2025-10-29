package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class NotificationRequestDTO {
    
    @NotNull(message = "User ID é obrigatório")
    private Long idUsuario;
    
    @NotBlank(message = "Título é obrigatório")
    private String titulo;
    
    @NotBlank(message = "Corpo da mensagem é obrigatório")
    private String corpo;
    
    private Map<String, String> data;

}