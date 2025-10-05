package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descServico;
    private Double custo;
    private Date dataInicio;
    private Date dataConclusao;

    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    @JsonBackReference
    private Manutencao manutencoes;
}
