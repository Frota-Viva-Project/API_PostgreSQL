package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationHistoryResponseDTO {
    
    private Long id;
    private Long userId;
    private String title;
    private String body;
    private String status;
    private String errorMessage;
    private LocalDateTime sentAt;

    public NotificationHistoryResponseDTO() {}

    public NotificationHistoryResponseDTO(Long id, Long userId, String title, String body, 
                                        String status, String errorMessage, LocalDateTime sentAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.status = status;
        this.errorMessage = errorMessage;
        this.sentAt = sentAt;
    }

}