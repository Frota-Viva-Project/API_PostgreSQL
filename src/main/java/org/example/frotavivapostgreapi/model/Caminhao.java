package org.example.frotavivapostgreapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "caminhao")
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private Boolean status;
    private Integer capacidade;

    @ManyToOne()
    @JoinColumn(name = "id_motorista")
    private Motorista motorista;

    @OneToOne(mappedBy = "caminhao")
    private Arduino arduino;

    @OneToMany(mappedBy = "caminhao")
    @JsonManagedReference
    private List<Manutencao> manutencoes;

    @OneToMany(mappedBy = "caminhao")
    @JsonManagedReference
    private List<RotaCaminhao> rotas;
}
