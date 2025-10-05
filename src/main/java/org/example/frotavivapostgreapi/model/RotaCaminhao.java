package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rota_caminhao")
public class RotaCaminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String destinoInicial;
    private String destinoFinal;
    private Double distancia;
    private String status;
    private Date dataChegadaPrevista;

    @ManyToOne()
    @JoinColumn(name = "id_caminhao")
    @JsonBackReference
    private Caminhao caminhao;
}

