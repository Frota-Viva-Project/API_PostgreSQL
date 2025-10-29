package org.example.frotavivapostgreapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Dados para cadastro/atualização de caminhão")
public class CaminhaoRequestDTO {
    
    @NotBlank(message = "Placa é obrigatória")
    @Schema(description = "Placa do caminhão", 
            example = "ABC-1234", 
            required = true,
            pattern = "^[A-Z]{3}-[0-9]{4}$")
    private String placa;
    
    @NotBlank(message = "Modelo é obrigatório")
    @Schema(description = "Modelo do caminhão", 
            example = "Volvo FH 540", 
            required = true)
    private String modelo;
    
    @NotNull(message = "Capacidade é obrigatória")
    @Positive(message = "Capacidade deve ser maior que zero")
    @Schema(description = "Capacidade de carga em quilogramas", 
            example = "25000", 
            required = true,
            minimum = "1")
    private Integer capacidade;
}
