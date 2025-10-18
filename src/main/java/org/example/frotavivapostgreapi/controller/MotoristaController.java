package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MotoristaController {
    @PostMapping("/motorista/{id_motorista}")
    ResponseEntity<CaminhaoResponseDTO> inserirMotorista(@RequestBody CaminhaoRequestDTO caminhaoRequestDTO, @PathVariable("id_motorista") Integer id_motorista, @RequestParam("cod_empresa") String cod_empresa);
}
