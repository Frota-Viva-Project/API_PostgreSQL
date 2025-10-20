package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    @NotNull
    private Integer tamanhoEmpresa;
    @NotNull
    private Integer tamanhoFrota;
    @NotBlank
    private String tipoEmpresa;
    @NotBlank
    private String areaAtuacao;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String cnae;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
}
