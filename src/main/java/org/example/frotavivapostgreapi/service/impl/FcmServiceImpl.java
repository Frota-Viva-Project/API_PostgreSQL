package org.example.frotavivapostgreapi.service.impl;

import com.google.firebase.messaging.*;
import org.example.frotavivapostgreapi.dto.FcmTokenRequestDTO;
import org.example.frotavivapostgreapi.dto.FcmTokenResponseDTO;
import org.example.frotavivapostgreapi.dto.NotificationHistoryResponseDTO;
import org.example.frotavivapostgreapi.model.FcmToken;
import org.example.frotavivapostgreapi.model.NotificationHistory;
import org.example.frotavivapostgreapi.repository.FcmTokenRepository;
import org.example.frotavivapostgreapi.repository.NotificationHistoryRepository;
import org.example.frotavivapostgreapi.service.FcmService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FcmServiceImpl implements FcmService {

    private final FcmTokenRepository fcmTokenRepository;
    private final NotificationHistoryRepository notificationHistoryRepository;

    public FcmServiceImpl(FcmTokenRepository fcmTokenRepository, 
                         NotificationHistoryRepository notificationHistoryRepository) {
        this.fcmTokenRepository = fcmTokenRepository;
        this.notificationHistoryRepository = notificationHistoryRepository;
    }

    @Override
    @Transactional
    public FcmTokenResponseDTO registerToken(FcmTokenRequestDTO request) {
        Optional<FcmToken> existingToken = fcmTokenRepository.findByIdUsuario(request.getIdUsuario());
        
        FcmToken fcmToken;
        if (existingToken.isPresent()) {
            fcmToken = existingToken.get();
            fcmToken.setFcmToken(request.getFcmToken());
            fcmToken.setIdCaminhao(request.getIdCaminhao());
            fcmToken.setAtivo(true);
        } else {
            fcmToken = new FcmToken();
            fcmToken.setIdUsuario(request.getIdUsuario());
            fcmToken.setFcmToken(request.getFcmToken());
            fcmToken.setIdCaminhao(request.getIdCaminhao());
            fcmToken.setAtivo(true);
        }
        
        fcmToken = fcmTokenRepository.save(fcmToken);
        
        return new FcmTokenResponseDTO(
            fcmToken.getId(),
            fcmToken.getIdUsuario(),
            fcmToken.getIdCaminhao(),
            fcmToken.getFcmToken(),
            fcmToken.getAtivo(),
            fcmToken.getCriadoEm(),
            fcmToken.getAtualizadoEm()
        );
    }

    @Override
    public void sendNotificationToUser(Long userId, String title, String body, Map<String, String> data) {
        List<FcmToken> tokens = fcmTokenRepository.findByIdUsuarioAndAtivoTrue(userId);
        
        for (FcmToken token : tokens) {
            sendSingleNotification(token.getFcmToken(), title, body, data, userId);
        }
    }

    @Override
    public void sendNotification(org.example.frotavivapostgreapi.dto.NotificationRequestDTO request) {
        sendNotificationToUser(request.getIdUsuario(), request.getTitulo(), request.getCorpo(), request.getData());
    }

    @Override
    public void sendAlertNotification(Long alertId, Long userId, String alertType, String message) {
        Map<String, String> data = new HashMap<>();
        data.put("type", "alert");
        data.put("id_alerta", alertId.toString());
        data.put("alert_type", alertType);
        
        String title = "Alerta do Veículo";
        sendNotificationToUser(userId, title, message, data);
    }

    @Override
    public void sendMaintenanceNotification(Long maintenanceId, Long userId, String message) {
        Map<String, String> data = new HashMap<>();
        data.put("type", "maintenance");
        data.put("id_manutencao", maintenanceId.toString());
        
        String title = "Manutenção Necessária";
        sendNotificationToUser(userId, title, message, data);
    }

    @Override
    @Transactional
    public void deactivateAllUserTokens(Long userId) {
        fcmTokenRepository.deactivateAllUserTokens(userId);
    }


    private void deactivateToken(String fcmToken) {
        fcmTokenRepository.deactivateToken(fcmToken);
    }

    @Override
    public List<NotificationHistoryResponseDTO> getNotificationHistory(Long userId) {
        List<NotificationHistory> history = notificationHistoryRepository.findByIdUsuarioOrderByEnviadaEmDesc(userId);
        
        return history.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private NotificationHistoryResponseDTO convertToDTO(NotificationHistory history) {
        return new NotificationHistoryResponseDTO(
            history.getId(),
            history.getIdUsuario(),
            history.getTitulo(),
            history.getCorpo(),
            history.getStatus(),
            history.getMessagemDeErro(),
            history.getEnviadaEm()
        );
    }

    private void sendSingleNotification(String fcmToken, String title, String body, 
                                      Map<String, String> data, Long userId) {
        try {
            Message.Builder messageBuilder = Message.builder()
                .setToken(fcmToken)
                .setNotification(Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build());

            if (data != null && !data.isEmpty()) {
                messageBuilder.putAllData(data);
            }

            Message message = messageBuilder.build();

            String response = FirebaseMessaging.getInstance().send(message);
            
            System.out.println("Notificação enviada com sucesso: " + response);
            
            saveNotificationHistory(userId, fcmToken, title, body, data, "SUCCESS", null);
            
        } catch (FirebaseMessagingException e) {
            System.err.println("Erro ao enviar notificação: " + e.getMessage());
            
            if (e.getMessagingErrorCode() == MessagingErrorCode.UNREGISTERED ||
                e.getMessagingErrorCode() == MessagingErrorCode.INVALID_ARGUMENT) {
                deactivateToken(fcmToken);
            }
            
            saveNotificationHistory(userId, fcmToken, title, body, data, "FAILED", e.getMessage());
        }
    }

    private void saveNotificationHistory(Long userId, String fcmToken, String title, String body,
                                       Map<String, String> data, String status, String errorMessage) {
        NotificationHistory history = new NotificationHistory();
        history.setIdUsuario(userId);
        history.setFcmToken(fcmToken);
        history.setTitulo(title);
        history.setCorpo(body);
        history.setDadosPayload(data != null ? data.toString() : null);
        history.setStatus(status);
        history.setMessagemDeErro(errorMessage);
        
        notificationHistoryRepository.save(history);
    }
}