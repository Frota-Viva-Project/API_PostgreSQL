package org.example.frotavivapostgreapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.frotavivapostgreapi.model.Caminhao;

import java.util.Date;

@Getter
@Setter
public class RotaCaminhaoResponseDTO {

    private Long id;
    private String destinoInicial;
    private String destinoFinal;
    private Double distancia;
    private String status;
    private Date dataChegadaPrevista;


}
