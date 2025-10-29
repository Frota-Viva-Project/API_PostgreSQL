package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.FcmTokenRequestDTO;
import org.example.frotavivapostgreapi.dto.FcmTokenResponseDTO;
import org.example.frotavivapostgreapi.dto.NotificationRequestDTO;
import org.example.frotavivapostgreapi.dto.NotificationHistoryResponseDTO;

import java.util.List;
import java.util.Map;

public interface FcmService {
    
    FcmTokenResponseDTO registerToken(FcmTokenRequestDTO request);
    void deactivateAllUserTokens(Long userId);
    
    void sendNotificationToUser(Long userId, String title, String body, Map<String, String> data);
    void sendNotification(NotificationRequestDTO request);
    void sendAlertNotification(Long alertId, Long userId, String alertType, String message);
    void sendMaintenanceNotification(Long maintenanceId, Long userId, String message);
    
    List<NotificationHistoryResponseDTO> getNotificationHistory(Long userId);
}