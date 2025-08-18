package org.example.frotavivapostgreapi.model;


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
    private Long idCaminhao;

    private String modelo;
    private String placa;
    private Integer capacidade;
    private String status;

}
