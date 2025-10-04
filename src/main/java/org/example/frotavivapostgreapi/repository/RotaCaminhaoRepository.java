package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface RotaCaminhaoRepository extends JpaRepository<RotaCaminhao, Long> {

    @Query(value = "SELECT * FROM rota_caminhao WHERE id_caminhao = :id_caminhao", nativeQuery = true)
    List<RotaCaminhao> findById(@PathVariable("id_caminhao") Integer id_caminhao);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO rota_caminhao (id_caminhao, status, destino_inicial, destino_final, distancia, data_chegada_prevista) " +
            "VALUES (:idCaminhao, :status, :destinoInicial, :destinoFinal, :distancia, :dataChegadaPrevista)",
            nativeQuery = true)
    void inserirRotaCaminhao(@Param("idCaminhao") Integer idCaminhao,
                             @Param("status") String status,
                             @Param("destinoInicial") String destinoInicial,
                             @Param("destinoFinal") String destinoFinal,
                             @Param("distancia") Double distancia,
                             @Param("dataChegadaPrevista") Date dataChegadaPrevista);
}
