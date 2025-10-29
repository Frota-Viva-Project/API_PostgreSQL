package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.FcmToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FcmTokenRepository extends JpaRepository<FcmToken, Long> {

    Optional<FcmToken> findByIdUsuario(Long userId);

    List<FcmToken> findByIdUsuarioAndAtivoTrue(Long userId);

    List<FcmToken> findByIdCaminhaoAndAtivoTrue(Long idCaminhao);

    @Modifying
    @Transactional
    @Query(value = "UPDATE fcm_tokens SET Ativo = false WHERE fcmToken = :fcmToken", nativeQuery = true)
    void deactivateToken(@Param("fcmToken") String fcmToken);

    @Modifying
    @Transactional
    @Query(value = "UPDATE fcm_tokens SET Ativo = false WHERE id_usuario = :idUsuario",nativeQuery = true)
    void deactivateAllUserTokens(@Param("idUsuario") Long idUsuario);
}