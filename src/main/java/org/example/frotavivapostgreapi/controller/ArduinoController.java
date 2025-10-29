package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.ArduinoResponseDTO;
import org.example.frotavivapostgreapi.model.Arduino;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Arduino", description = "Dados dos sensores Arduino dos caminhões")
public interface ArduinoController {
    
    @Operation(summary = "Buscar dados do Arduino", 
               description = "Retorna os dados dos sensores Arduino de um caminhão específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Dados do Arduino retornados com sucesso"),
        @ApiResponse(responseCode = "404", description = "Arduino ou caminhão não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/arduino/{id_caminhao}")
    ResponseEntity<ArduinoResponseDTO> listById(
        @Parameter(description = "ID do caminhão", required = true)
        @PathVariable("id_caminhao") Integer id);
}
