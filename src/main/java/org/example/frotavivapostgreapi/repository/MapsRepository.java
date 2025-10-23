package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Maps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Date;

public interface MapsRepository extends JpaRepository<Maps,Long> {
    @Query(value = "SELECT * FROM maps WHERE id = :id_maps",
            nativeQuery = true)
    Maps findById(@Param("id") Integer id_maps);

    @Transactional
    @Query(value = "INSERT INTO maps (latitude, longitude, captura_localizacao_ml) " +
            "VALUES (:latitude, :longitude, :capturaLocalizacaoMl)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirMaps(@Param("latitude") Double latitude,
                        @Param("longitude") Double longitude,
                        @Param("capturaLocalizacaoMl") BigInteger capturaLocalizacaoMl);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maps SET latitude = :latitude, longitude = :longitude, captura_localizacao_ml = :capturaLocalizacaoMl WHERE id = :id_maps",
            nativeQuery = true)
    void atualizarMaps(@Param("id") Integer id_maps,
                       @Param("latitude") Double latitude,
                       @Param("longitude") Double longitude,
                       @Param("capturaLocalizacaoMl") BigInteger capturaLocalizacaoMl);
}
