package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.AlertaRequestDTO;
import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AlertaController {

    @GetMapping("/alerta/{id_caminhao}")
    ResponseEntity<List<AlertaResponseDTO>> listarAlertas(@PathVariable("id_caminhao") Integer id_caminhao);

    @PostMapping("/alerta/{id_caminhao}")
    ResponseEntity<AlertaResponseDTO> inserirAlerta(@PathVariable("id_caminhao") Integer id_caminhao, @RequestBody AlertaRequestDTO alertaRequestDTO);

    @PatchMapping("/alerta")
    ResponseEntity<HttpStatus> finalizarAlerta(@RequestParam("id_alerta") Integer id_alerta, @RequestParam("id_caminhao") Integer id_caminhao);
}
