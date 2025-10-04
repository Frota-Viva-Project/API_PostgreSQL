package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RotaCaminhaoController {
    @GetMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<List<RotaCaminhaoResponseDTO>> listById(@PathVariable("id_caminhao") Integer id_caminhao);
}
