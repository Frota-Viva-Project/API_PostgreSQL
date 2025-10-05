package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.example.frotavivapostgreapi.model.Manutencao;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ManutecaoService {


    List<ManutencaoResponseDTO> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
