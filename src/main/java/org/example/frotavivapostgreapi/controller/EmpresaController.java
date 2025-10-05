package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.EmpresaResponseDTO;
import org.example.frotavivapostgreapi.model.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmpresaController {
    @GetMapping("/empresa/{id_empresa}")
    ResponseEntity<EmpresaResponseDTO> listById(@PathVariable("id_empresa") Integer id_empresa);
}
