package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.AuthRequestDTO;
import org.example.frotavivapostgreapi.dto.AuthResponseDTO;
import org.example.frotavivapostgreapi.dto.FirebaseAuthRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuários")
public interface AuthController {
    
    @Operation(summary = "Login tradicional", 
               description = "Autenticação com usuário e senha")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
        @ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO);
    
    @Operation(summary = "Autenticação Firebase", 
               description = "Troca Firebase ID Token por JWT da API")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Autenticação Firebase realizada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Token Firebase inválido"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    @PostMapping("/firebase")
    ResponseEntity<AuthResponseDTO> authenticateWithFirebase(@RequestBody FirebaseAuthRequestDTO request);
}