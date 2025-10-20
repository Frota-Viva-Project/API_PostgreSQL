package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertaRequestDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String categoria;
    @NotBlank
    private String descricao;

}
