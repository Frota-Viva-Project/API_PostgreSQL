package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.ServicoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Serviços", description = "Gerenciamento de serviços de manutenção")
public interface ServicoController {

    @Operation(summary = "Criar novo serviço", 
               description = "Cria um novo serviço associado a uma manutenção")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Serviço criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Manutenção não encontrada"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/servico/{idManutencao}")
    ResponseEntity<ServicoResponseDTO> inseriServico(
        @Parameter(description = "ID da manutenção", required = true)
        @PathVariable Integer idManutencao, 
        @Parameter(description = "Descrição do serviço", required = true)
        @RequestParam String descServico);
}
