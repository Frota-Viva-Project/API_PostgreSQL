package org.example.frotavivapostgreapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "manutencao")
public class Maps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    @Column(name = "captura_localizacao_ml")
    private BigInteger capturaLocalizacaoMl;
}
