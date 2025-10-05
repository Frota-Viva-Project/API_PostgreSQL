package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlertaController {

    @GetMapping("/alerta/{id_caminhao}")
    ResponseEntity<List<AlertaResponseDTO>> listarAlertas(@PathVariable("id_caminhao") Integer id_caminhao);
}
