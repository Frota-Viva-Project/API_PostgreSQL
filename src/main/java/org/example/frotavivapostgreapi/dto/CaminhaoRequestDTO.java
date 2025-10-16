package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaminhaoRequestDTO {
    private String placa;

    private String modelo;

    private Integer capacidade;
}
