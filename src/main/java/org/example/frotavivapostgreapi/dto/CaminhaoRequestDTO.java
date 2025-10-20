package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaminhaoRequestDTO {
    @NotBlank
    private String placa;
    @NotBlank
    private String modelo;
    @NotNull
    private Integer capacidade;
}
