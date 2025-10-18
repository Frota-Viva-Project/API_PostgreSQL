package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public interface CaminhaoController {

    @GetMapping("/caminhoes/{id_motorista}")
    ResponseEntity<CaminhaoResponseDTO> listById(@PathVariable("id_motorista") Integer id_motorista);

}
