package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManutencaoRequestDTO {
    @NotBlank
    private String info;
    @NotBlank
    private String titulo;
}
