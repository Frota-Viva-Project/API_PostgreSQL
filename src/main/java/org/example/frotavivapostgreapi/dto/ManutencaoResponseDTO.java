package org.example.frotavivapostgreapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.example.frotavivapostgreapi.model.Servico;

import java.util.List;

@Getter
@Setter
public class ManutencaoResponseDTO {

    private Long id;

    private String tipoManutencao;

    private Double tempoManutencao;

    private List<ServicoResponseDTO> servico;
}
