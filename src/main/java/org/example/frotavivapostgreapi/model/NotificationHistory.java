package org.example.frotavivapostgreapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "historico_notificacoes")
public class NotificationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario_destino", nullable = false)
    private Long idUsuario;

    @Column(name = "fcm_token", nullable = false, length = 500)
    private String fcmToken;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "corpo", nullable = false, columnDefinition = "TEXT")
    private String corpo;

    @Column(name = "dados_payload", columnDefinition = "TEXT")
    private String dadosPayload;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "messagem_de_erro", columnDefinition = "TEXT")
    private String messagemDeErro;

    @Column(name = "enviada_em", nullable = false)
    private LocalDateTime  enviadaEm;

    @PrePersist
    protected void onCreate() {
        enviadaEm = LocalDateTime.now();
    }
}