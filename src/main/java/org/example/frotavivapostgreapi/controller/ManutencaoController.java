package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.ManutencaoRequestDTO;
import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.frotavivapostgreapi.model.Manutencao;

import java.util.List;

@Tag(name = "Manutenções", description = "Gerenciamento de manutenções dos caminhões")
public interface ManutencaoController {

    @Operation(summary = "Listar manutenções do caminhão", 
               description = "Retorna todas as manutenções de um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manutenções retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<List<ManutencaoResponseDTO>> listByIdCaminhao(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Criar nova manutenção", 
               description = "Cria uma nova manutenção para um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Manutenção criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<ManutencaoResponseDTO> inseriManutencao(
        @RequestBody ManutencaoRequestDTO manutencaoRequestDTO, 
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Finalizar manutenção", 
               description = "Marca uma manutenção como finalizada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Manutenção finalizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Manutenção ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/manutencao/caminhao")
    ResponseEntity<HttpStatus> finalizarManutencao(
        @Parameter(description = "ID da manutenção", required = true)
        @RequestParam("id_manuntecao") Integer id_manuntecao,
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Solicitar serviço para manutenção", 
               description = "Solicita um serviço especializado para a manutenção")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Serviço solicitado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Manutenção ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/manutencao/caminhao/servico")
    ResponseEntity<HttpStatus> solicitarServico(
        @Parameter(description = "ID da manutenção", required = true)
        @RequestParam("id_manuntecao") Integer id_manuntecao,
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);
}
