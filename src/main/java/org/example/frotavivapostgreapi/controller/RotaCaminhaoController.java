package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RotaCaminhaoController {
    @GetMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<List<RotaCaminhaoResponseDTO>> listById(@PathVariable("id_caminhao") Integer id_caminhao);

    @PostMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<RotaCaminhaoResponseDTO> inseriRotaCaminhao(@RequestBody RotaCaminhaoRequestDTO rotaCaminhaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao);

    @PatchMapping("/rota_caminhao/em_rota")
    ResponseEntity<HttpStatus> updateStatusToEmRota(@RequestParam("id_rotacaminhao") Integer id_rotacaminhao, @RequestParam("id_caminhao") Integer id_caminhao);

    @PatchMapping("/rota_caminhao/finalizada")
    ResponseEntity<HttpStatus> updateStatusToFinalizada(@RequestParam("id_rotacaminhao") Integer id_rotacaminhao, @RequestParam("id_caminhao") Integer id_caminhao);
}
