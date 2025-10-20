package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RotaCaminhaoRequestDTO {

    @NotBlank
    private String destinoInicial;
    @NotBlank
    private String destinoFinal;
    @NotNull
    private Double distancia;
    @NotNull
    private Date dataChegadaPrevista;

}
