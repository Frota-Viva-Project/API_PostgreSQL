package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.MapsRequestDTO;
import org.example.frotavivapostgreapi.dto.MapsResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Maps - Localização", description = "Gerenciamento de dados de localização e mapas")
public interface MapsController {
    
    @Operation(summary = "Buscar dados de localização", 
               description = "Retorna os dados de localização por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Dados de localização encontrados"),
        @ApiResponse(responseCode = "404", description = "Localização não encontrada"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/maps/{id_maps}")
    ResponseEntity<MapsResponseDTO> buscarMaps(
        @Parameter(description = "ID da localização", required = true)
        @PathVariable Integer id_maps);
    
    @Operation(summary = "Inserir nova localização", 
               description = "Cria um novo registro de localização")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Localização criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/maps")
    ResponseEntity<Integer> inserirMaps(@RequestBody MapsRequestDTO mapsRequestDTO);
    
    @Operation(summary = "Atualizar localização", 
               description = "Atualiza os dados de uma localização existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Localização atualizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Localização não encontrada"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PutMapping("/maps/{id_maps}")
    ResponseEntity<HttpStatus> atualizarMaps(
        @Parameter(description = "ID da localização", required = true)
        @PathVariable Integer id_maps, 
        @RequestBody MapsRequestDTO mapsRequestDTO);
}
