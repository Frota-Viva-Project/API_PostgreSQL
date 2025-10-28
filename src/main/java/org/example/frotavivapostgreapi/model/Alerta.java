package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alerta")
public class Alerta {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String categoria;

    private String descricao;

    private String titulo;

    @ManyToOne()
    @JoinColumn(name = "id_caminhao")
    @JsonBackReference
    private Caminhao caminhao;

}
