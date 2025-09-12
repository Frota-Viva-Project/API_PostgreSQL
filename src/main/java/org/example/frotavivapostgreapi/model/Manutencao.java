package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoManutencao;
    private Double tempoManutencao;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caminhao")
    @JsonBackReference
    private Caminhao caminhao;

    @OneToMany
    @JoinColumn(name = "id_manutencao")
    @JsonManagedReference
    private List<Servico> servico;
}
