package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rota_caminhao")
public class RotaCaminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String localInicial;
    private String localFinal;
    @Column(name = "cidade_inicial")
    private String cidadeInicial;
    @Column(name = "cidade_final")
    private String cidadeFinal;
    @Column(name = "estado_inicial")
    private String estadoInicial;
    @Column(name = "estado_final")
    private String estadoFinal;
    private Double distancia;

    @ManyToOne()
    @JoinColumn(name = "id_caminhao")
    @JsonBackReference
    private Caminhao caminhao;
}

