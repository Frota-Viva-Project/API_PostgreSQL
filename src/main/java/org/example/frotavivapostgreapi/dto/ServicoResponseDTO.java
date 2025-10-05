package org.example.frotavivapostgreapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.frotavivapostgreapi.model.Manutencao;

import java.util.Date;

@Getter
@Setter
public class ServicoResponseDTO {

    private Long id;
    private String descServico;
    private Double custo;
    private Date dataInicio;
    private Date dataConclusao;

}
