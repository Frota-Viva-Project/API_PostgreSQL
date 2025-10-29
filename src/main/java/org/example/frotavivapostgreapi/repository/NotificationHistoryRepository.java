package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationHistoryRepository extends JpaRepository<NotificationHistory, Long> {

    List<NotificationHistory> findByIdUsuarioOrderByEnviadaEmDesc(Long userId);
    
    @Query(value = "SELECT * FROM historico_notificacoes WHERE id_usuario = :userId ORDER BY enviada_em DESC", nativeQuery = true)
    List<NotificationHistory> findByUserIdOrderBySentAtDesc(@Param("idUsuario") Long idUsuario, org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT * FROM historico_notificacoes WHERE id_usuario = :idUsuario AND enviada_em >= :since ORDER BY enviada_em DESC", nativeQuery = true)
    List<NotificationHistory> findByUserIdAndSentAtAfter(@Param("idUsuario") Long idUsuario, @Param("since") LocalDateTime since);

    @Query(value = "SELECT COUNT(*) FROM historico_notificacoes WHERE status = :status AND enviada_em >= :since", nativeQuery = true)
    Long countByStatusAndSentAtAfter(@Param("status") String status, @Param("since") LocalDateTime since);
}