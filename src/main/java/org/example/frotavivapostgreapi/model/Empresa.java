package org.example.frotavivapostgreapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cnpj;

    private Integer tamanhoEmpresa;

    private Integer tamanhoFrota;

    private String tipoEmpresa;

    private String areaAtuacao;

    private String razaoSocial;

    private String cnae;

    private String telefone;

    private String endereco;
}
