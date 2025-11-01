package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    @Query(value = "SELECT * FROM alerta WHERE id_caminhao = :id_caminhao",nativeQuery = true)
    List<Alerta> findById(@PathVariable("id_caminhao") Integer id_caminhao);


    @Transactional
    @Query(value = "INSERT INTO alerta (status,id_caminhao, descricao, titulo, categoria) " +
            "VALUES ('PENDENTE', :idCaminhao, :descricao, :titulo, :categoria)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirAlerta(@Param("idCaminhao") Integer idCaminhao,
                           @Param("descricao") String descricao,
                           @Param("titulo") String titulo,
                           @Param("categoria") String categoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE alerta SET status = 'CONCLUIDO' WHERE id = :id_alerta",
            nativeQuery = true)
    void finalizarAlerta(@Param("id_alerta") Integer id_alerta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE alerta SET status = 'MANUTENÇÃO' WHERE id = :id_alerta",
            nativeQuery = true)
    void solicitarManutencao(@Param("id_alerta") Integer id_alerta);
}
