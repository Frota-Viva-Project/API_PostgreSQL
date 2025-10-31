package org.example.frotavivapostgreapi.controller.impl;

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
public class FcmControllerImpl implements FcmController {

    private final FcmService fcmService;

    public FcmControllerImpl(FcmService fcmService) {
        this.fcmService = fcmService;
    }

    @Override
    public ResponseEntity<FcmTokenResponseDTO> registerToken(@Valid @RequestBody FcmTokenRequestDTO request) {
        FcmTokenResponseDTO response = fcmService.registerToken(request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> sendNotification(@Valid @RequestBody org.example.frotavivapostgreapi.dto.NotificationRequestDTO request) {
        fcmService.sendNotification(request);
        return ResponseEntity.ok("Notificação enviada com sucesso");
    }

    @Override
    public ResponseEntity<String> deactivateUserTokens(@PathVariable Long userId) {
        fcmService.deactivateAllUserTokens(userId);
        return ResponseEntity.ok("Tokens desativados com sucesso");
    }

    @Override
    public ResponseEntity<List<NotificationHistoryResponseDTO>> getNotificationHistory(@PathVariable Long userId) {
        List<NotificationHistoryResponseDTO> history = fcmService.getNotificationHistory(userId);
        return ResponseEntity.ok(history);
    }
}