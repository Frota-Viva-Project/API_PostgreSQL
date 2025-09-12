package org.example.frotavivapostgreapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "arduino")
public class Arduino {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "velocidade_veiculo")
    private Double velocidadeVeiculo;

    @Column(name = "rotacoes_minuto_motor")
    private Integer rotacoesMinutoMotor;

    @Column(name = "carga_motor")
    private Double cargaMotor;

    @Column(name = "tempo_motor_ligado", nullable = false)
    private Integer tempoMotorLigado;

    @Column(name = "posicao_acelerador")
    private Double posicaoAcelerador;

    @Column(name = "consumo_combustivel")
    private Double consumoCombustivel;

    @Column(name = "nivel_combustivel")
    private Double nivelCombustivel;

    @Column(name = "status_sistema_combustivel", nullable = false, length = 20)
    private String statusSistemaCombustivel = "UNKNOWN";

    @Column(name = "quilometragem")
    private Double quilometragem;

    @Column(name = "temperatura_liquido_arrefecimento")
    private Double temperaturaLiquidoArrefecimento;

    @Column(name = "temperatura_ar_admissao")
    private Double temperaturaArAdmissao;

    @Column(name = "pressao_oleo_motor")
    private Double pressaoOleoMotor;

    @Column(name = "pressao_coletor_admissao")
    private Double pressaoColetorAdmissao;

    @Column(name = "leitura_sensores_oxigenio")
    private Double leituraSensoresOxigenio;

    @Column(name = "leitura_sensor_oxigenio_2")
    private Double leituraSensorOxigenio2;

    @Column(name = "tensao_bateria")
    private Double tensaoBateria;

    @Column(name = "codigos_diagnostico_ativos")
    private String codigosDiagnosticoAtivos;

    @Column(name = "codigos_diagnostico_pendentes")
    private String codigosDiagnosticoPendentes;

    @Column(name = "data_hora_leitura")
    private LocalDateTime dataHoraLeitura;

    @OneToOne()
    @JoinColumn(name = "id_caminhao")
    @JsonIgnore
    private Caminhao caminhao;

}
