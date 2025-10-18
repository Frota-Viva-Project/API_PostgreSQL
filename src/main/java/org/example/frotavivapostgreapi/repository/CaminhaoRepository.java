package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query(value = "SELECT * FROM caminhao WHERE id_motorista = :id_motorista", nativeQuery = true)
    Caminhao findById(@PathVariable("id_motorista") Integer id_motorista);


    @Transactional
    @Query(value = "INSERT INTO caminhao (id_motorista ,status, capacidade, placa, modelo) " +
            "VALUES (:id_motorista ,'ATIVO', :capacidade, :placa, :modelo)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirCaminhao(@Param("id_motorista") Integer id_motorista,
                           @Param("capacidade") Integer capacidade,
                           @Param("placa") String placa,
                           @Param("modelo") String modelo);
}
