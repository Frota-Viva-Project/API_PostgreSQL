package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.frotavivapostgreapi.model.Arduino;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.example.frotavivapostgreapi.model.Motorista;
import org.example.frotavivapostgreapi.model.RotaCaminhao;

import java.util.List;

@Getter
@Setter
public class CaminhaoResponseDTO {
    private Long id;

    private String placa;
    private String modelo;
    private String status;
    private Integer capacidade;

    private MotoristaResponseDTO motorista;

    private ArduinoResponseDTO arduino;

    private List<ManutencaoResponseDTO> manutencoes;

    private List<RotaCaminhaoResponseDTO> rotas;
}
