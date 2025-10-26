package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirebaseAuthRequestDTO {
    @NotBlank(message = "Firebase ID Token é obrigatório")
    private String firebaseIdToken;

}