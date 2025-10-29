package org.example.frotavivapostgreapi.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FcmTokenResponseDTO {

    private Long id;
    private Long idUsuario;
    private Long idCaminhao;
    private String fcmToken;
    private Boolean ativo = true;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public FcmTokenResponseDTO() {}

    public FcmTokenResponseDTO(Long id, Long userId, Long truckId, String fcmToken, 
                              Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.idUsuario = userId;
        this.idCaminhao = truckId;
        this.fcmToken = fcmToken;
        this.ativo = isActive;
        this.criadoEm = createdAt;
        this.atualizadoEm = updatedAt;
    }

}