package org.example.frotavivapostgreapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotorista;

    private String nome;
    private String email;
    private String senha;
    private String telefoneMotorista;
    private String telefoneEmpresa;
    private String cnpjEmpresa;




}
