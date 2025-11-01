package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Motoristas", description = "Gerenciamento de motoristas e associação com caminhões")
public interface MotoristaController {
    
    @Operation(summary = "Associar motorista a caminhão", 
               description = "Associa um motorista a um caminhão de uma empresa específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Motorista associado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Motorista ou empresa não encontrados"),
        @ApiResponse(responseCode = "409", description = "Motorista já possui caminhão associado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/motorista/{id_motorista}")
    ResponseEntity<CaminhaoResponseDTO> inserirMotorista(
        @RequestBody CaminhaoRequestDTO caminhaoRequestDTO, 
        @Parameter(description = "ID do motorista", required = true)
        @PathVariable("id_motorista") Integer id_motorista, 
        @Parameter(description = "Código da empresa", required = true)
        @RequestParam("cod_empresa") String cod_empresa);

    @Operation(summary = "Buscar motorista por caminhão",
               description = "Busca o motorista associado a um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Motorista encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/motorista/{id}")
    ResponseEntity<Integer> buscarMotoristaPorCaminhao(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id") Integer id);

}
