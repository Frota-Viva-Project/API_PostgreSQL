package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.AlertaRequestDTO;
import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Alertas", description = "Gerenciamento de alertas dos caminhões")
public interface AlertaController {

    @Operation(summary = "Listar alertas do caminhão", 
               description = "Retorna todos os alertas de um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de alertas retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/alerta/{id_caminhao}")
    ResponseEntity<List<AlertaResponseDTO>> listarAlertas(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Criar novo alerta", 
               description = "Cria um novo alerta para um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alerta criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/alerta/{id_caminhao}")
    ResponseEntity<AlertaResponseDTO> inserirAlerta(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id_caminhao, 
        @RequestBody AlertaRequestDTO alertaRequestDTO);

    @Operation(summary = "Finalizar alerta", 
               description = "Marca um alerta como finalizado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alerta finalizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Alerta ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/alerta")
    ResponseEntity<HttpStatus> finalizarAlerta(
        @Parameter(description = "ID do alerta", required = true)
        @RequestParam("id_alerta") Integer id_alerta, 
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);

    @Operation(summary = "Solicitar serviço para alerta", 
               description = "Solicita um serviço de manutenção para resolver o alerta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Serviço solicitado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Alerta ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/alerta/servico")
    ResponseEntity<HttpStatus> solicitarServico(
        @Parameter(description = "ID do alerta", required = true)
        @RequestParam("id_alerta") Integer id_alerta, 
        @Parameter(description = "ID do caminhão", required = true)
        @RequestParam("id_caminhao") Integer id_caminhao);
}
