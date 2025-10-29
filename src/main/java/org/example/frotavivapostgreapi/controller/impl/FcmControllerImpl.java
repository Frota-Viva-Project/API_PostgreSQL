package org.example.frotavivapostgreapi.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.controller.FcmController;
import org.example.frotavivapostgreapi.dto.FcmTokenRequestDTO;
import org.example.frotavivapostgreapi.dto.FcmTokenResponseDTO;
import org.example.frotavivapostgreapi.dto.NotificationHistoryResponseDTO;
import org.example.frotavivapostgreapi.service.FcmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/fcm")
@Tag(name = "FCM", description = "Endpoints para gerenciamento de notificações push")
public class FcmControllerImpl implements FcmController {

    private final FcmService fcmService;

    public FcmControllerImpl(FcmService fcmService) {
        this.fcmService = fcmService;
    }

    @Override
    @Operation(summary = "Registrar FCM Token", description = "Registra ou atualiza o FCM token do usuário")
    public ResponseEntity<FcmTokenResponseDTO> registerToken(@Valid @RequestBody FcmTokenRequestDTO request) {
        FcmTokenResponseDTO response = fcmService.registerToken(request);
        return ResponseEntity.ok(response);
    }

    @Override
    @Operation(summary = "Enviar Notificação", description = "Envia uma notificação push para um usuário")
    public ResponseEntity<String> sendNotification(@Valid @RequestBody org.example.frotavivapostgreapi.dto.NotificationRequestDTO request) {
        fcmService.sendNotification(request);
        return ResponseEntity.ok("Notificação enviada com sucesso");
    }

    @Override
    @Operation(summary = "Desativar Tokens", description = "Desativa todos os tokens FCM de um usuário")
    public ResponseEntity<String> deactivateUserTokens(@PathVariable Long userId) {
        fcmService.deactivateAllUserTokens(userId);
        return ResponseEntity.ok("Tokens desativados com sucesso");
    }

    @Override
    @Operation(summary = "Histórico de Notificações", description = "Busca TODAS as notificações de um usuário (sem limite)")
    public ResponseEntity<List<NotificationHistoryResponseDTO>> getNotificationHistory(@PathVariable Long userId) {
        List<NotificationHistoryResponseDTO> history = fcmService.getNotificationHistory(userId);
        return ResponseEntity.ok(history);
    }
}