package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.FcmTokenRequestDTO;
import org.example.frotavivapostgreapi.dto.FcmTokenResponseDTO;
import org.example.frotavivapostgreapi.dto.NotificationHistoryResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FcmController {
    
    @PutMapping("/register")
    ResponseEntity<FcmTokenResponseDTO> registerToken(@RequestBody FcmTokenRequestDTO request);
    
    @PostMapping("/send")
    ResponseEntity<String> sendNotification(@RequestBody org.example.frotavivapostgreapi.dto.NotificationRequestDTO request);
    
    @DeleteMapping("/token/{userId}")
    ResponseEntity<String> deactivateUserTokens(@PathVariable Long userId);
    
    @GetMapping("/history/{userId}")
    ResponseEntity<List<NotificationHistoryResponseDTO>> getNotificationHistory(@PathVariable Long userId);
}