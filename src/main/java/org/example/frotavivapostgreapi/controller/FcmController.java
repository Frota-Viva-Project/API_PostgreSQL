package org.example.frotavivapostgreapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.frotavivapostgreapi.dto.FcmTokenRequestDTO;
import org.example.frotavivapostgreapi.dto.FcmTokenResponseDTO;
import org.example.frotavivapostgreapi.dto.NotificationHistoryResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/api/fcm")
@Tag(name = "FCM - Notificações Push", description = "Gerenciamento de notificações push via Firebase Cloud Messaging")
public interface FcmController {
    
    @Operation(summary = "Registrar token FCM", 
               description = "Registra ou atualiza o token FCM de um usuário para receber notificações push")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Token registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PutMapping("/register")
    ResponseEntity<FcmTokenResponseDTO> registerToken(@RequestBody FcmTokenRequestDTO request);
    
    @Operation(summary = "Enviar notificação", 
               description = "Envia uma notificação push para usuários específicos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notificação enviada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/send")
    ResponseEntity<String> sendNotification(@RequestBody org.example.frotavivapostgreapi.dto.NotificationRequestDTO request);
    
    @Operation(summary = "Desativar tokens do usuário", 
               description = "Desativa todos os tokens FCM de um usuário específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tokens desativados com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @DeleteMapping("/token/{userId}")
    ResponseEntity<String> deactivateUserTokens(
        @Parameter(description = "ID do usuário", required = true)
        @PathVariable Long userId);
    
    @Operation(summary = "Histórico de notificações", 
               description = "Retorna o histórico de notificações de um usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Histórico retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/history/{userId}")
    ResponseEntity<List<NotificationHistoryResponseDTO>> getNotificationHistory(
        @Parameter(description = "ID do usuário", required = true)
        @PathVariable Long userId);
}