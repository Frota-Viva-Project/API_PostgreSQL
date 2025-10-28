package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.ManutencaoRequestDTO;
import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.frotavivapostgreapi.model.Manutencao;

import java.util.List;


public interface ManutencaoController {

    @GetMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<List<ManutencaoResponseDTO>> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);

    @PostMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<ManutencaoResponseDTO> inseriManutencao(@RequestBody ManutencaoRequestDTO manutencaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao);

    @PatchMapping("/manutencao/caminhao")
    ResponseEntity<HttpStatus> finalizarManutencao(@RequestParam("id_manuntecao") Integer id_manuntecao,@RequestParam("id_caminhao") Integer id_caminhao);

    @PatchMapping("/manutencao/caminhao/servico")
    ResponseEntity<HttpStatus> solicitarServico(@RequestParam("id_manuntecao") Integer id_manuntecao,@RequestParam("id_caminhao") Integer id_caminhao);
}
