package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ArduinoResponseDTO {

    private Long id;

    private Double velocidadeVeiculo;

    private Integer rotacoesMinutoMotor;

    private Double cargaMotor;

    private Integer tempoMotorLigado;

    private Double posicaoAcelerador;

    private Double consumoCombustivel;

    private Double nivelCombustivel;

    private String statusSistemaCombustivel = "UNKNOWN";

    private Double quilometragem;

    private Double temperaturaLiquidoArrefecimento;

    private Double temperaturaArAdmissao;

    private Double pressaoOleoMotor;

    private Double pressaoColetorAdmissao;

    private Double leituraSensoresOxigenio;

    private Double leituraSensorOxigenio2;

    private Double tensaoBateria;

    private String codigosDiagnosticoAtivos;

    private String codigosDiagnosticoPendentes;

    private Date dataHoraLeitura;

}
