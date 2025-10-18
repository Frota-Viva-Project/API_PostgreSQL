package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequestDTO {
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

    private String email;

    private String senha;
}
