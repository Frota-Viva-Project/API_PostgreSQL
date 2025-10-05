package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ManutencaoController {

    @GetMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<List<ManutencaoResponseDTO>> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
