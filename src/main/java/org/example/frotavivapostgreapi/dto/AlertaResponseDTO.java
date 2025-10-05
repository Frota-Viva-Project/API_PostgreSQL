package org.example.frotavivapostgreapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.frotavivapostgreapi.model.Caminhao;

@Getter
@Setter
public class AlertaResponseDTO {

    private Long id;

    private Boolean status;

    private String tipoAlerta;

    private String descricao;

}
