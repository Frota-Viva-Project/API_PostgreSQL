package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.ManutencaoRequestDTO;
import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ManutecaoService {


    List<ManutencaoResponseDTO> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);

    ManutencaoResponseDTO inseriManutencao(@RequestBody ManutencaoRequestDTO manutencaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao);
}
