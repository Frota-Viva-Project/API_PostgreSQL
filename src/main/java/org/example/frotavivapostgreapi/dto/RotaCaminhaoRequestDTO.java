package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RotaCaminhaoRequestDTO {

    private String destinoInicial;
    private String destinoFinal;
    private Double distancia;
    private Date dataChegadaPrevista;

}
