package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FcmTokenRequestDTO {
    
    @NotNull(message = "User ID é obrigatório")
    private Long idUsuario;
    
    @NotBlank(message = "FCM Token é obrigatório")
    private String fcmToken;
    
    private Long idCaminhao;
}