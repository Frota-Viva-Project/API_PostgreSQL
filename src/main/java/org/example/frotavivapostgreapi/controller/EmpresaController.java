package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.EmpresaRequestDTO;
import org.example.frotavivapostgreapi.dto.EmpresaResponseDTO;
import org.example.frotavivapostgreapi.model.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Empresas", description = "Gerenciamento de empresas de transporte")
public interface EmpresaController {
    
    @Operation(summary = "Buscar empresa por ID", 
               description = "Retorna os dados de uma empresa específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Empresa encontrada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Empresa não encontrada"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/empresa/{id_empresa}")
    ResponseEntity<EmpresaResponseDTO> listById(
        @Parameter(description = "ID da empresa", required = true)
        @PathVariable("id_empresa") Integer id_empresa);

    @Operation(summary = "Cadastrar nova empresa", 
               description = "Cria uma nova empresa no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Empresa criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "409", description = "Empresa já existe"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/empresa")
    ResponseEntity<EmpresaResponseDTO> inserirEmpresa(@RequestBody EmpresaRequestDTO empresaRequestDTO);
}
