package org.example.frotavivapostgreapi.model;


import jakarta.persistence.*;

@Entity
@Table(name = "arduino")
public class Arduino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArduino;

    private String cargaMotor;

    private String atributo1;
    private String atributo2;
    private String atributo3;


}
