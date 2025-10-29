package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Caminhões", description = "Gerenciamento da frota de caminhões")
public interface CaminhaoController {

    @Operation(summary = "Buscar caminhão por motorista", 
               description = "Retorna o caminhão associado a um motorista específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Caminhão encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Motorista ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/caminhoes/{id_motorista}")
    ResponseEntity<CaminhaoResponseDTO> listById(
        @Parameter(description = "ID do motorista", required = true)
        @PathVariable("id_motorista") Integer id_motorista);
}
