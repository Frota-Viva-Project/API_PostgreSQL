package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rotas", description = "Gerenciamento de rotas dos caminhões")
public interface RotaCaminhaoController {
    
    @Operation(summary = "Listar rotas do caminhão", 
               description = "Retorna todas as rotas de um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de rotas retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<List<RotaCaminhaoResponseDTO>> listById(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Criar nova rota", 
               description = "Cria uma nova rota para um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Rota criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<RotaCaminhaoResponseDTO> inseriRotaCaminhao(
        @RequestBody RotaCaminhaoRequestDTO rotaCaminhaoRequestDTO, 
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Marcar rota como em andamento", 
               description = "Atualiza o status da rota para 'em rota'")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Rota ou caminhão não encontrado"),
        @ApiResponse(responseCode = "400", description = "Status inválido para esta operação"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/rota_caminhao/em_rota")
    ResponseEntity<HttpStatus> updateStatusToEmRota(
        @Parameter(description = "ID da rota", required = true)
        @RequestParam("id_rotacaminhao") Integer id_rotacaminhao, 
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Finalizar rota", 
               description = "Marca a rota como finalizada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rota finalizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Rota ou caminhão não encontrado"),
        @ApiResponse(responseCode = "400", description = "Status inválido para esta operação"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/rota_caminhao/finalizada")
    ResponseEntity<HttpStatus> updateStatusToFinalizada(
        @Parameter(description = "ID da rota", required = true)
        @RequestParam("id_rotacaminhao") Integer id_rotacaminhao, 
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);
}
